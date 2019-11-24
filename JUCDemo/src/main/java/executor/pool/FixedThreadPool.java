package executor.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Created by xmr on 2017/6/6.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //最好根据机器核心数来创建线程池个数
        System.out.println("机器核心数：" + Runtime.getRuntime().availableProcessors());
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        ExecutorService exec = new ThreadPoolExecutor(
                5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        //在新的jdk版本中，这种写法已经不能再使用了
//        ExecutorService exec = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 24; i++) {
            exec.execute(new MyThread());
        }
        exec.shutdown();
    }
}
