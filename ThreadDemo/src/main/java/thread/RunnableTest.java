package thread;

/**
 * Created by xmr on 2018/9/21.
 */
public class RunnableTest {
    /**
     * 三个线程共享一个runnable的资源
     * @param args
     */
    public static void main(String[] args) {
        RunnableTask mTh = new RunnableTask();
        new Thread(mTh, "C").start();//
        new Thread(mTh, "D").start();
        new Thread(mTh, "E").start();
    }

}

class RunnableTask implements Runnable {
    private int count = 15;

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            Thread.yield();//让出了处理器时间
        }
    }

}
