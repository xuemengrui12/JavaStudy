package threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xmr on 2018/8/31.
 */
public class ThreadLocalDemo {
    private static SimpleDateFormat sdf
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static ThreadLocal<SimpleDateFormat> t1
            = new ThreadLocal<SimpleDateFormat>();

    static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        public void run() {
            try {
                Date t = sdf.parse("2018-09-01 10:25:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadLocalDate implements Runnable {
        int i = 0;

        public ThreadLocalDate(int i) {
            this.i = i;
        }

        public void run() {
            if (t1.get()==null)
                t1.set(new SimpleDateFormat());
            try {
                Date date=t1.get().parse("2018-09-01 10:35:" + i % 60);
                System.out.println(i + ":" + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService
                = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ParseDate(i));
        }
    }
}
