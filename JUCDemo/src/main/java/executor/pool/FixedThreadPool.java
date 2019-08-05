package executor.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2017/6/6.
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        System.out.println("机器核心数："+Runtime.getRuntime().availableProcessors());
//根据机器核心数来创建线程池个数
        ExecutorService exec = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 24; i++)
            exec.execute(new MyThread());
        exec.shutdown();
    }
}
