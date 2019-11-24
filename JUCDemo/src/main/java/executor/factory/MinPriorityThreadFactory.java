package executor.factory;

/**
 * Created by xmr on 2017/6/6.
 */

import java.util.concurrent.ThreadFactory;

/**
 * 最低优先级
 */
public class MinPriorityThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MIN_PRIORITY);
        return t;
    }
}
