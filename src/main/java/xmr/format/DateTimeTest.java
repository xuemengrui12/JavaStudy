package xmr.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xmr on 2019/8/24.
 */
public class DateTimeTest {


    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
// Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue()); // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());

        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
// Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));


        Date date = new Date();
        Locale[] locales = {Locale.CHINA, Locale.US};
        DateFormat[] dateFormats = new DateFormat[16];
        for (int i = 0; i < locales.length; i++) {
            dateFormats[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            dateFormats[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }
        for (int i = 0; i < locales.length; i++){
            switch (i) {
                case 0:
                    System.out.println("————中国的格式————");
                    break;
                case 1:
                    System.out.println("————美国的格式————");
                    break;
            }
            System.out.println("SHORT格式的日期：" + dateFormats[i * 8].format(date));
            System.out.println("MEDIUM格式的日期：" + dateFormats[i * 8+1].format(date));
            System.out.println("LONG格式的日期：" + dateFormats[i * 8+2].format(date));
            System.out.println("FULL格式的日期：" + dateFormats[i * 8+3].format(date));
            System.out.println("SHORT格式的时间：" + dateFormats[i * 8+4].format(date));
            System.out.println("MEDIUM格式的时间：" + dateFormats[i * 8+5].format(date));
            System.out.println("LONG格式的时间：" + dateFormats[i * 8+6].format(date));
            System.out.println("FULL格式的时间：" + dateFormats[i * 8+7].format(date));
        }
    }

}

