package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2018/9/16.
 */
public class NIOServer {
    //通道选择器
    private Selector selector;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    //统计服务器线程在一个客户端花费的时间
    public static Map<Socket, Long> timeStat = new HashMap<Socket, Long>();

    /**
     * 函数功能：初始化serverSocketChannel来监听指定的端口是否有新的TCP连接，
     * 并将serverSocketChannel注册到selector中
     */
    private void init() {
        try {
            //获得服务端ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false); //设置为非阻塞模式
            //serverSocketChannel监听指定端口
            InetSocketAddress isa = new InetSocketAddress(8000);
            serverSocketChannel.socket().bind(isa);

                /*
                 * 将serverSocketChannel注册到selector中,并为该通道注册selectionKey.OP_ACCEPT事件
                 * 注册该事件后，当事件到达的时候，selector.select()会返回，
                 * 如果事件没有到达selector.select()会一直阻塞
                 */
            // selector = SelectorProvider.provider().openSelector();
            selector = Selector.open();//获得Selector实例
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 函数功能：服务器端开始监听，看是否有客户端连接进来
     * */
    private void startServer() throws Exception {
        System.out.println("server running....");
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();
            // 获得selector中相应的迭代器，选中注册的事件
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            long e = 0;
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 删除已选的key 以防重复处理
                iterator.remove();
                if (selectionKey.isAcceptable()) {//如果有客户端连接进来
                    doAccept(selectionKey);

                } else if (selectionKey.isValid() && selectionKey.isReadable()) {//客户端发送数据过来了
                    doRead(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isWritable()) {//客户端写数据准备
                    doWrite(selectionKey);
                }
            }

        }

    }


    private void doAccept(SelectionKey selectionKey) throws IOException {
        //先拿到这个SelectionKey里面的ServerSocketChannel。
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        // 获得和客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("有客户端连接到服务器！！！");
        socketChannel.configureBlocking(false);//将此通道设置为非阻塞
        //为了接收客户端发送过来的数据，需要将此通道绑定到选择器上，并为该通道注册读事件
        SelectionKey clientKey = socketChannel.register(selector, SelectionKey.OP_READ);
        EchoCliet echoCliet = new EchoCliet();
        clientKey.attach(echoCliet);

        InetAddress clientAddress = socketChannel.socket().getInetAddress();
        System.out.println("accept connection from " + clientAddress.getHostAddress());
//        socketChannel.write(ByteBuffer.wrap(new String("hello client!").getBytes()));
    }

    private void doWrite(SelectionKey selectionKey) {
//先拿到这个SelectionKey里面的SocketChannel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        EchoCliet echoCliet = (EchoCliet) selectionKey.attachment();
        LinkedList<ByteBuffer> outq = echoCliet.getOutq();
        ByteBuffer bb = outq.getLast();
        try {
            int len = socketChannel.write(bb);
            if (len == -1) {
                socketChannel.close();
//                selectionKey.selector().close();
                return;
            }
            if (bb.remaining() == 0)
                outq.removeLast();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (outq.size() == 0)
            selectionKey.interestOps(SelectionKey.OP_READ);
    }

    private void doRead(SelectionKey selectionKey) {
        //先拿到这个SelectionKey里面的SocketChannel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        //接收来自于客户端发送过来的数据
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int len = 0;
        System.out.println("服务器端接收到的数据为：");
        //接收来自于客户端发送过来的数据
        try {
            len = socketChannel.read(buf);
            if (len < 0) {
                socketChannel.close();
//                selectionKey.selector().close();
                return;
            }
            buf.flip();
            // 使用GBK的字符集来创建解码器
            Charset charset = Charset.forName("utf-8");
            // 创建解码器(CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将ByteBuffer转换成CharBuffer
            CharBuffer charBuffer = decoder.decode(buf);
            // CharBuffer的toString方法可以获取对应的字符串
            System.out.println(charBuffer.toString());
            buf.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        executorService.execute(new HandleMsg(selectionKey, buf));
    }

    class HandleMsg implements Runnable {
        SelectionKey selectionKey;
        ByteBuffer bb;

        public HandleMsg(SelectionKey selectionKey, ByteBuffer bb) {
            this.selectionKey = selectionKey;
            this.bb = bb;
        }

        public void run() {
            EchoCliet echoCliet = (EchoCliet) selectionKey.attachment();
            echoCliet.enqueue(bb);
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }

    class EchoCliet {
        private LinkedList<ByteBuffer> outq;

        public EchoCliet() {
            outq = new LinkedList<ByteBuffer>();

        }

        public LinkedList<ByteBuffer> getOutq() {
            return outq;
        }

        public void enqueue(ByteBuffer bb) {
            outq.addFirst(bb);
        }
    }

    public static void main(String[] args) throws Exception {
        NIOServer server = new NIOServer();
        server.init();
        server.startServer();
    }
}
