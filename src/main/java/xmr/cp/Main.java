package xmr.cp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 手写生产者消费者模式
 * Created by xmr on 2019/8/3.
 */
public class Main {
    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();
        int maxSize = 5;
        final Producer p = new Producer(queue, maxSize);
        final Consumer c = new Consumer(queue, maxSize);
        p.put(1);
        p.put(2);
        p.put(3);
        p.put(4);
        p.put(5);
        Thread pT = new Thread(new Runnable() {
            @Override
            public void run() {
                p.put(6);
                p.put(7);
            }
        });
        pT.start();
        Thread pC = new Thread(new Runnable() {
            @Override
            public void run() {
                c.get();

            }
        });
        pC.start();
        new Thread() {
            public void run() {
                c.get();
            }
        }.start();
    }
}
