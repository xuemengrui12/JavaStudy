package executor.factory;


import executor.pool.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2017/6/6.
 */
public class ExecFromFactory {
    public static void main(String[] args) throws Exception {
        ExecutorService defaultExec = Executors.newCachedThreadPool();
        ExecutorService daemonExec = Executors
                .newCachedThreadPool(new DaemonThreadFactory());
        ExecutorService maxPriorityExec = Executors
                .newCachedThreadPool(new MaxPriorityThreadFactory());
        ExecutorService minPriorityExec = Executors
                .newCachedThreadPool(new MinPriorityThreadFactory());
        for (int i = 0; i < 10; i++)
            if (i == 3)
                daemonExec.execute(new MyThread());
            else if (i == 5)
                maxPriorityExec.execute(new MyThread());
            else if (i == 7)
                minPriorityExec.execute(new MyThread());
            else
                defaultExec.execute(new MyThread());
    }
}
