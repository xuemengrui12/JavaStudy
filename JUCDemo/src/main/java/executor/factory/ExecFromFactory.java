package executor.factory;


import executor.pool.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启动带有属性设置的线程
 * Created by xmr on 2017/6/6.
 */
public class ExecFromFactory {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService defaultExec = Executors
                .newCachedThreadPool(Executors.defaultThreadFactory());
        ExecutorService daemonExec = Executors
                .newCachedThreadPool(new DaemonThreadFactory());
        ExecutorService maxPriorityExec = Executors
                .newCachedThreadPool(new MaxPriorityThreadFactory());
        ExecutorService minPriorityExec = Executors
                .newCachedThreadPool(new MinPriorityThreadFactory());
        MyThread t = new MyThread();
        for (int i = 0; i < 10; i++) {
            if (i == 1) {
                defaultExec.execute(t);
            } else if (i == 3) {
                daemonExec.execute(t);
            } else if (i == 5) {
                maxPriorityExec.execute(t);
            } else if (i == 7) {
                minPriorityExec.execute(t);
            } else {
                executorService.execute(t);
            }
        }
    }
}
