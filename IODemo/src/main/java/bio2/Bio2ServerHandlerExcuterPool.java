package bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 */
public class Bio2ServerHandlerExcuterPool {

    private int maxPoolSize;
    private int queueSize;
    private ExecutorService executorService;

    public Bio2ServerHandlerExcuterPool(int maxPoolSize, int queueSize) {
        this.maxPoolSize = maxPoolSize;
        this.queueSize = queueSize;
        executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void execute(Runnable task) {
        executorService.execute(task);
    }

}
