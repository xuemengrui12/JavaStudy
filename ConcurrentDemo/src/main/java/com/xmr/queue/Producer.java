package com.xmr.queue;

import java.util.concurrent.BlockingQueue;

/**
 * Created by xmr on 2019/7/21.
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;
    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
