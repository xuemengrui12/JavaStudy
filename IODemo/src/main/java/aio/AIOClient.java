package aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by xmr on 2018/9/18.
 */
public class AIOClient implements Runnable {
    private AsynchronousSocketChannel channel;

    public AIOClient() {
        try {
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 8001);
        channel.connect(serverAddress, null, new CompletionHandler<Void, Object>() {

            @Override
            public void completed(Void result, Object attachment) {
                channel.write(ByteBuffer.wrap("Hello server".getBytes()));
                final ByteBuffer buffer = ByteBuffer.allocate(1024);
                channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {

                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        buffer.flip();
                        System.out.println(new String(buffer.array()));
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                    }

                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
            }

        });
    }

    public static void main(String[] args) throws IOException {

        new Thread(new AIOClient()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
