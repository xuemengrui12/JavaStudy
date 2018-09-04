package executor.factory;

/**
 * Created by xmr on 2017/6/6.
 */

import java.util.concurrent.ThreadFactory;

/**
 * 最高优先级
 */
public class MaxPriorityThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.MAX_PRIORITY);
        return t;
    }
}
