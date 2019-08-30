package xmr.format;

import java.text.ParseException;

/**
 * Created by xmr on 2019/8/24.
 */
public class DateUtilTest {
    public static class TestSimpleDateFormatThreadSafe extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    this.join(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    System.out.println(this.getName() + ":" + DateUtil.parse("2019-05-24 06:02:20"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new TestSimpleDateFormatThreadSafe().start();
        }

    }
}
