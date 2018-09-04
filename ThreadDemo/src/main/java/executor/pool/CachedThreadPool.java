package executor.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2017/6/6.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++)
            exec.execute(new MyThread());
        exec.shutdown();
    }
}
