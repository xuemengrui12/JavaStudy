package xmr.format;

import java.time.LocalDateTime;

/**
 * Created by xmr on 2019/11/23.
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue()); // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
    }
}

