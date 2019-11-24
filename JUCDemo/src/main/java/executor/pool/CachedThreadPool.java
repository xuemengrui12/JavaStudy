package executor.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by xmr on 2017/6/6.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService exec = new ThreadPoolExecutor(
                5, 200, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        //在新的jdk版本中，这种写法已经不能再使用了
        //ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new MyThread());
        }
        exec.shutdown();

    }
}
