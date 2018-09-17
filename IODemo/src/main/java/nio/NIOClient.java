package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xmr on 2018/9/16.
 */
public class NIOClient {
    //通道选择器
    private Selector selector;

    private void init() {
        try {
            // selector = SelectorProvider.provider().openSelector();
            selector = Selector.open();//获得Selector实例
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false); //设置为非阻塞模式
            socketChannel.connect(new InetSocketAddress("localhost", 8000));
                /*
                 * 将socketChannel注册到selector中,并为该通道注册selectionKey.OP_CONNECT事件
                 * 注册该事件后，当事件到达的时候，selector.select()会返回，
                 * 如果事件没有到达selector.select()会一直阻塞
                 */
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void working() throws Exception {
        System.out.println("cliet running....");
        while (true) {
            if (!selector.isOpen())
                break;
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();
            // 获得selector中相应的迭代器，选中注册的事件
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 删除已选的key 以防重复处理
                iterator.remove();
                if (selectionKey.isConnectable()) {
                    connect(selectionKey);
                } else if (selectionKey.isValid() && selectionKey.isReadable()) {//客户端发送数据过来了
                    read(selectionKey);
                }
            }
        }
    }

    /*从SocketChannel中读取数据*/
    private void read(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            byte[] data = buffer.array();
            String msg = new String(data).trim();
            System.out.println("msg: " + msg);
            socketChannel.close();
            selectionKey.selector().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        try {
            if (socketChannel.isConnectionPending())
                socketChannel.finishConnect();
            socketChannel.configureBlocking(false);//设置为非阻塞模式
            //给服务器端发送数据
            socketChannel.write(ByteBuffer.wrap(new String("hello server").getBytes()));
            //为了接收来自服务器端的数据，将此通道注册到选择器中
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        NIOClient client = new NIOClient();
        client.init();
        client.working();
    }
}
