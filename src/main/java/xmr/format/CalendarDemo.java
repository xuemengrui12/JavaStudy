package xmr.format;

import java.time.Clock;
import java.util.Calendar;

/**
 * Created by xmr on 2019/11/23.
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(Calendar.YEAR));
//        System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
//        System.out.println(cal.get(Calendar.DATE));
//        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
//        System.out.println(cal.get(Calendar.MINUTE));
//        System.out.println(cal.get(Calendar.SECOND));
        //创建一个代表2019年11月23日的Calendar对象
        cal.set(2019, 10, 23);

        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        // Java 8
        System.out.println(Clock.systemDefaultZone().millis());
        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

}
