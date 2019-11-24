package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.*;

/**
 * Created by xmr on 2018/9/18.
 */
public class AIOEchoServer implements Runnable{
    public final static int PORT = 8001;
    public final static String IP = "127.0.0.1";


    private AsynchronousServerSocketChannel server = null;

    public AIOEchoServer() {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(20);
            AsynchronousChannelGroup asyncChannelGroup = AsynchronousChannelGroup.withThreadPool(executor);
            server = AsynchronousServerSocketChannel.open(asyncChannelGroup).bind(new InetSocketAddress(IP, PORT));
            //同样是利用工厂方法产生一个通道，异步通道 AsynchronousServerSocketChannel
//            server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(IP,PORT));
            //通过setOption配置Socket
            server.setOption(StandardSocketOptions.SO_REUSEADDR, true);
            server.setOption(StandardSocketOptions.SO_RCVBUF, 16 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用这个通道(server)来进行客户端的接收和处理
    @Override
    public void run() {
        System.out.println("Server listen on " + PORT);

        //注册事件和事件完成后的处理器，这个CompletionHandler就是事件完成后的处理器
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {

                System.out.println(Thread.currentThread().getName());
                Future<Integer> writeResult = null;

                try {
                    buffer.clear();
                    //把socket中的数据读取到buffer中
                    result.read(buffer).get(100, TimeUnit.SECONDS);

                    System.out.println("In server: " + new String(buffer.array()));

                    buffer.flip();
                    //将数据写回客户端
                    writeResult = result.write(buffer);
                    buffer.flip();
                } catch (InterruptedException | ExecutionException | TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        System.out.println(writeResult.get());
                        //关闭处理完的socket，并重新调用accept等待新的连接
                        result.close();
                        server.accept(null, this);
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed:" + exc);
            }

        });
    }

    public static void main(String[] args) {
        //因为AIO不会阻塞调用进程，因此必须在主进程阻塞，才能保持进程存活。
        new Thread(new AIOEchoServer()).start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
