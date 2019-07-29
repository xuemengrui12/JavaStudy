package thread;

/**
 * Created by xmr on 2018/9/21.
 */
public class ThreadTest {

    public static void main(String[] args) {
//        Thread1 mTh1 = new Thread1();
//        Thread1 mTh2 = new Thread1();
//        mTh1.setName("mTh1");
//        mTh2.setName("mTh2");
//        mTh1.start();
//        mTh2.start();

        /**
         * 分析：当多个线程访问threadTask的run方法时，以排队的方式进行处理（这里排对是按照CPU分配的先后顺序而定的），
         * 		一个线程想要执行synchronized修饰的方法里的代码：
         * 		1 尝试获得锁
         * 		2 如果拿到锁，执行synchronized代码体内容；拿不到锁，这个线程就会不断的尝试获得这把锁，直到拿到为止，
         * 		   而且是多个线程同时去竞争这把锁。（也就是会有锁竞争的问题）
         */
//        由于资源征用，所以5个线程并不会顺序执行
        ThreadTask threadTask = new ThreadTask();
        new Thread(threadTask, "t1").start();
        new Thread(threadTask, "t2").start();
        new Thread(threadTask, "t3").start();
        new Thread(threadTask, "t4").start();
        new Thread(threadTask, "t5").start();
    }
}

class Thread1 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count--);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class ThreadTask extends Thread {
    int count = 5;

    //synchronized加锁
    @Override
    public void run() {
        count--;
        System.out.println(this.currentThread().getName() + ":  " + count);
    }
}




