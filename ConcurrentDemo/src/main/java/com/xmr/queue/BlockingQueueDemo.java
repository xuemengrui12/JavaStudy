package com.xmr.queue;


import java.util.concurrent.*;

/**
 * Created by xmr on 2019/7/19.
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        BlockingQueue queue = new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
        Thread.sleep(4000);
    }
}
