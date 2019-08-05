package executor.callable;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by xmr on 2018/8/28.
 * 启动10条线程，谁先执行完成就返回谁
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建包含10条线程的线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(executor);
        for (int i =1; i <=10; i ++) {
            final  int result = i;
            completionService.submit(new Callable() {
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));   //让当前线程随机休眠一段时间
                    return result;
                }
            });
        }
        System.out.println(completionService.take().get());   //获取执行结果
    }
}
