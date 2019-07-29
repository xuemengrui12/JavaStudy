package executor.callable;

import java.util.concurrent.*;

/**
 * Created by xmr on 2018/8/28.
 */
public class CallableAndFuture {


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future=exec.submit(new RealData("future"));//直接运行
        FutureTask<String> futureTask=new FutureTask<String>(new RealData("futureTask"));
        try {
            exec.submit(futureTask);
            System.out.println("future任务的执行结果："+future.get());
            System.out.println("futureTask任务的执行结果："+futureTask.get());
            exec.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
