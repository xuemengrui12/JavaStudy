package aio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangdecheng on 24/03/2018.
 */
public class ServerAio {

    int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asynServerSocketChannel;

    public ServerAio(int port) {
        this.port = port;
        try {
//           asynServerSocketChannel = AsynchronousServerSocketChannel.open();
//           asynServerSocketChannel.bind(new InetSocketAddress(port));

            ExecutorService executor = Executors.newFixedThreadPool(20);
            AsynchronousChannelGroup asyncChannelGroup = AsynchronousChannelGroup.withThreadPool(executor);
            asynServerSocketChannel = AsynchronousServerSocketChannel.open(asyncChannelGroup).bind(new InetSocketAddress(port));
            System.out.println("The aio server is start in port:" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        latch = new CountDownLatch(1);
        asynServerSocketChannel.accept(this, new AcceptCompletionHandler());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        ServerAio serverAio = new ServerAio(8080);
        serverAio.start();
    }

    class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, ServerAio> {
        @Override
        public void completed(AsynchronousSocketChannel result, ServerAio attachment) {
            attachment.asynServerSocketChannel.accept(attachment, this);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            result.read(buffer, buffer, new ReadCompletionHandler(result));
        }

        @Override
        public void failed(Throwable exc, ServerAio attachment) {

            exc.printStackTrace();
            attachment.latch.countDown();
        }
    }
}
