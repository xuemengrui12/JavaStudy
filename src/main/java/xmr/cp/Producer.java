package xmr.cp;

import java.util.Queue;

/**
 * 生产者消费者模式
 * Created by xmr on 2019/8/3.
 */
public class Producer {
    private Queue<Object> queue;
    private int maxSize;

    public Producer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public void put(Object obj) {
        synchronized (queue) {
            while (queue.size() == this.maxSize) {
                try {
                    System.out.println("Queue is Full");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //加入元素
            queue.add(obj);
            queue.notify();
            System.out.println("新加入的元素为:" + obj);
        }
    }
}
