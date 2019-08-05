package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
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



    /**
     * 初始化serverSocketChannel来监听指定的端口是否有新的TCP连接，
     * 并将serverSocketChannel注册到selector中
     * 函数功能：服务器端开始监听，看是否有客户端连接进来
     */
    private void startServer() throws Exception {
        try {
            //1、创建Selector
            // selector = SelectorProvider.provider().openSelector();
            selector = Selector.open();//获得Selector实例
            //2、通过ServerSocketChannel创建Channel通道，获得服务端ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //3、为channel通道绑定监听端口
            serverSocketChannel.socket().bind(new InetSocketAddress(8000));//serverSocketChannel监听指定端口
            //4、设置channel为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            /*
             * 将serverSocketChannel注册到selector中,并为该通道注册selectionKey.OP_ACCEPT事件
             * 注册该事件后，当事件到达的时候，selector.select()会返回，
             * 如果事件没有到达selector.select()会一直阻塞
             */
            //5、将channel注册到selector上，监听连接事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server running....");
        //6、循环等待新接入的连接,for(;;)经过代码优化是一条语句，while（true）是3条
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            int readyChannels = selector.select(); //TODO 获取可用channel数量
            if (readyChannels == 0)
                continue;
            //获取可用Channel的集合
            Set<SelectionKey> set = selector.selectedKeys();
            //获得selector中相应的迭代器，选中注册的事件
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 删除已选的key 以防重复处理
                iterator.remove();
                //7、根据就绪状态，调用对应方法处理业务逻辑
                if (selectionKey.isValid()) {
                    if (selectionKey.isAcceptable()) {//如果是接入事件
                        doAccept(selectionKey);
                    } else if (selectionKey.isReadable()) {//如果是可读事件
                        doRead(selectionKey);
                    }
//                    if (selectionKey.isWritable()) {//服务端写数据准备
//                    doWrite(selectionKey);
//                    }
                }

            }

        }

    }


    /**
     * @param selectionKey
     * @throws IOException 如果是接入事件，创建SocketChannel
     *                     将SocketChannel设置为非阻塞模式
     *                     将channel注册到selector上，监听可读事件
     *                     回复客户端提示信息
     */
    private void doAccept(SelectionKey selectionKey) throws IOException {
        //先拿到这个SelectionKey里面的ServerSocketChannel。
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        // 获得和客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("有客户端连接到服务器！！！");
        socketChannel.configureBlocking(false);//将此通道设置为非阻塞
        //为了接收客户端发送过来的数据，需要将此通道绑定到选择器上，并为该通道注册读事件
        SelectionKey clientKey = socketChannel.register(selector, SelectionKey.OP_READ);//可读事件
//        EchoClient echoClient = new EchoClient();
//        clientKey.attach(echoClient);
//        socketChannel.write(Charset.forName("UTF-8").encode("已经与服务建立连接"));//回复客户端提示信息
        InetAddress clientAddress = socketChannel.socket().getInetAddress();
        System.out.println("accept connection from " + clientAddress.getHostAddress());
        socketChannel.write(ByteBuffer.wrap("hello client!".getBytes()));
    }

    private void doWrite(SelectionKey selectionKey) {
        //先拿到这个SelectionKey里面的SocketChannel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        EchoClient echoClient = (EchoClient) selectionKey.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutq();
        ByteBuffer bb = outq.getLast();
        try {
            int len = socketChannel.write(ByteBuffer.wrap(new String("hello client!!!").getBytes()));

//            int len = socketChannel.write(bb);
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

    /**
     * @param selectionKey 可读事件处理器
     *                     要从selectionKey中获取到已经就绪的channel
     *                     创建buffer
     *                     循环读取客户端请求信息
     *                     将channel再次注册到selector上，监听他的可读事件
     *                     将客户端发送的请求信息，广播给其他客户端
     */
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
            buf.flip();//切换buf为读模式
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

//        executorService.execute(new HandleMsg(selectionKey, buf));
    }

    class HandleMsg implements Runnable {
        SelectionKey selectionKey;
        ByteBuffer bb;

        public HandleMsg(SelectionKey selectionKey, ByteBuffer bb) {
            this.selectionKey = selectionKey;
            this.bb = bb;
        }

        public void run() {
            EchoClient echoCliet = (EchoClient) selectionKey.attachment();
            echoCliet.enqueue(bb);
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }

    class EchoClient {
        private LinkedList<ByteBuffer> outq;

        public EchoClient() {
            outq = new LinkedList<>();
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
        server.startServer();
    }
}
