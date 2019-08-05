package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2018/9/18.
 */
public class AIOEchoServer {
    private final static int PORT = 8001;

    private boolean writing = false;
    private AsynchronousServerSocketChannel server = null;

    private final Queue<ByteBuffer> queue = new LinkedList<>();


    public AIOEchoServer() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(20);
//            AsynchronousChannelGroup channelGroup
//                    = AsynchronousChannelGroup.withFixedThreadPool(
//                            Runtime.getRuntime().availableProcessors(), Executors.defaultThreadFactory());
            AsynchronousChannelGroup asyncChannelGroup = AsynchronousChannelGroup.withThreadPool(executor);
            server = AsynchronousServerSocketChannel.open(asyncChannelGroup).bind(new InetSocketAddress(PORT));
            //同样是利用工厂方法产生一个通道，异步通道 AsynchronousServerSocketChannel
//            server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用这个通道(server)来进行客户端的接收和处理
    public void start() {
        System.out.println("Server listen on " + PORT);

        //注册事件和事件完成后的处理器，这个CompletionHandler就是事件完成后的处理器
        server.accept(this, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println(Thread.currentThread().getName() + ": run in accept completed method");

                server.accept(null, this);
                handler(result);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("server accept failed: " + exc);

            }
        });

    }

    private void handler(final AsynchronousSocketChannel channel) {
        System.out.println(Thread.currentThread().getName());
        final ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.clear();
        channel.read(buffer, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                System.out.println(Thread.currentThread().getName()
                        + ": run in read completed method");
                if (result > 0) {
                    try {
                        buffer.flip();
                        //CharBuffer charBuffer = CharsetHelper.decode(readBuffer);
                        CharBuffer charBuffer = Charset.forName("UTF-8").newDecoder().decode(buffer);
                        String question = charBuffer.toString();
//                        String answer = Helper.getAnswer(question);
                        writeStringMessage(channel, question);

                        buffer.clear();
                    } catch (CharacterCodingException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        //如果客户端关闭socket，那么服务器也需要关闭，否则浪费CPU
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //异步调用OS处理下个读取请求
                //这里传入this是个地雷，小心多线程
                channel.read(buffer, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("server read failed: " + exc);
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    private void writeMessage(final AsynchronousSocketChannel channel, final ByteBuffer buffer) {
        boolean threadShouldWrite = false;

        synchronized(queue) {
            queue.add(buffer);
            // Currently no thread writing, make this thread dispatch a write
            if (!writing) {
                writing = true;
                threadShouldWrite = true;
            }
        }

        if (threadShouldWrite) {
            writeFromQueue(channel);
        }
    }

    private void writeFromQueue(final AsynchronousSocketChannel channel) {
        ByteBuffer buffer;

        synchronized (queue) {
            buffer = queue.poll();
            if (buffer == null) {
                writing = false;
            }
        }

        // No new data in buffer to write
        if (writing) {
            writeBuffer(channel, buffer);
        }
    }

    private void writeBuffer(final AsynchronousSocketChannel channel, ByteBuffer buffer) {
        channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer buffer) {
                if (buffer.hasRemaining()) {
                    channel.write(buffer, buffer, this);
                } else {
                    // Go back and check if there is new data to write
                    writeFromQueue(channel);
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("server write failed: " + exc);
            }
        });
    }

    /**
     * Sends a message
     * @param msg
     * @throws CharacterCodingException
     */
    private void writeStringMessage(final AsynchronousSocketChannel channel, String msg) throws CharacterCodingException {
        writeMessage(channel, Charset.forName("UTF-8").newEncoder().encode(CharBuffer.wrap(msg)));
    }


    public static void main(String[] args) {
        new AIOEchoServer().start();
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
