package executor.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Created by xmr on 2017/6/6.
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        // 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
//        BasicThreadFactory namedThreadFactory = ;
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();

        ScheduledExecutorService exec = new ScheduledThreadPoolExecutor(
                2, namedThreadFactory);
//        new BasicThreadFactory.Builder()
//                .namingPattern("example-schedule-pool-%d").daemon(true).build());
        //在新的jdk版本中，这种写法已经不能再使用了
//        ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);
        MyThread t1 = new MyThread();
        exec.execute(t1);// 将线程放入池中进行执行
        MyThread t2 = new MyThread();
        exec.schedule(t2, 1000, TimeUnit.MILLISECONDS);// 使用延迟执行风格的方法
        exec.shutdown();
    }
}
