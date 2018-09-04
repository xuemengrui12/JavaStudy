package executor.factory;

import java.util.concurrent.ThreadFactory;

/**
 * Created by xmr on 2017/6/6.
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
