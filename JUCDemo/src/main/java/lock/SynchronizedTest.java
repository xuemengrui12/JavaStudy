package lock;

/**
 * Created by xmr on 2018/8/3.
 */
public class SynchronizedTest {

    public void doSth1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Hello World");
        }
    }

    public synchronized void doSth2() {
        System.out.println("Hello World");
    }

    public static synchronized void doSth3() {
        System.out.println("Hello World");
    }

}
