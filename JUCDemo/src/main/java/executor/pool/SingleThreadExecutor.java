package executor.pool;

import executor.pool.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2017/6/6.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
//        ExecutorService exec=
        for (int i = 0; i < 5; i++) {
            exec.execute(new MyThread());
        }
        exec.shutdown();
    }
}
