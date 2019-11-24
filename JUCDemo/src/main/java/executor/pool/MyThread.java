package executor.pool;

/**
 * Created by xmr on 2017/6/6.
 */
public class MyThread implements Runnable {

    public MyThread() {
    }

    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
