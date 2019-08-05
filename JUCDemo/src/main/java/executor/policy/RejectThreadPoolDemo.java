package executor.policy;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;

/**
 * 自定义线程池和拒绝策略
 * Created by xmr on 2018/9/5.
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" +
                    Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*自定义线程池和拒绝策略*/
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),//默认创建线程的实现方式，可以省略
                new RejectedExecutionHandler() {
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " is discard");
                    }
                });
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
        es.shutdown();
    }
}
