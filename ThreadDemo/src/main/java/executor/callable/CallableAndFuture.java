package executor.callable;

import java.util.concurrent.*;

/**
 * Created by xmr on 2018/8/28.
 */
public class CallableAndFuture {
    static class CallableTest implements Callable<String>{
        public String call() throws Exception {
            return "Hello World";
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> future=exec.submit(new CallableTest());//直接运行
        FutureTask<String> futureTask=new FutureTask<String>(new CallableTest());
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
