package xmr.format;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xmr on 2019/8/24.
 */
public class DateFormatDemo {
    Locale[] locales = {Locale.CHINA, Locale.US};

    public static void main(String[] args) {
        DateFormatDemo dateFormatDemo = new DateFormatDemo();
//        dateFormatDemo.testSimpleDateFormat();
        dateFormatDemo.testGetDateTimeInstance();
    }


    /**
     * SimpleDateFormat测试类
     */
    public void testSimpleDateFormat() {
        // 初始化 Date 对象
        Date date = new Date();
//        SimpleDateFormat ft =
//                new SimpleDateFormat("E yyyy-MM-dd 'at' hh:mm:ss a zzz");

//        System.out.println("Current Date: " + ft.format(date));
//        String str = String.format("Current Date/Time : %tc", date );
//        System.out.printf(str);

//        System.out.printf("%1$s %2$tB %2$td, %2$tY", "Due date:", date);

        // 显示格式化时间
//        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String input = "2019-11-23";
        Date t;
        try {
            t = ft.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }

        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
// Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));

    }

    private void testGetTimeInstance() {
        // 初始化 Date 对象
        Date date = new Date();
        DateFormat[] dateFormats = new DateFormat[8];
        for (int i = 0; i < locales.length; i++) {
            dateFormats[i * 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 4 + 1] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 4 + 2] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 4 + 3] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }
        for (int i = 0; i < locales.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("————中国的格式————");
                    break;
                case 1:
                    System.out.println("————美国的格式————");
                    break;
            }
            System.out.println("SHORT格式的日期：" + dateFormats[i * 4].format(date));
            System.out.println("MEDIUM格式的日期：" + dateFormats[i * 4 + 1].format(date));
            System.out.println("LONG格式的日期：" + dateFormats[i * 4 + 2].format(date));
            System.out.println("FULL格式的日期：" + dateFormats[i * 4 + 3].format(date));
        }
    }

    private void testGetDateTimeInstance() {
        // 初始化 Date 对象
        Date date = new Date();
        DateFormat[] dateFormats = new DateFormat[12];
        for (int i = 0; i < locales.length; i++) {
            dateFormats[i * 4] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, locales[i]);
            dateFormats[i * 4 + 1] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 4 + 2] = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 4 + 3] = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, locales[i]);
        }
        dateFormats[8] = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
        dateFormats[9] = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        dateFormats[10] = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);
        dateFormats[11] = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM);
        for (int i = 0; i < locales.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("————中国的格式————");
                    break;
                case 1:
                    System.out.println("————美国的格式————");
                    break;
            }
            System.out.println("SHORT格式的日期：" + dateFormats[i * 4].format(date));
            System.out.println("MEDIUM格式的日期：" + dateFormats[i * 4 + 1].format(date));
            System.out.println("LONG格式的日期：" + dateFormats[i * 4 + 2].format(date));
            System.out.println("FULL格式的日期：" + dateFormats[i * 4 + 3].format(date));
        }
        System.out.println("---------------------------------");
        System.out.println("SHORT格式的日期：" + dateFormats[8].format(date));
        System.out.println("MEDIUM格式的日期：" + dateFormats[9].format(date));
        System.out.println("LONG格式的日期：" + dateFormats[10].format(date));
        System.out.println("FULL格式的日期：" + dateFormats[11].format(date));
    }

    public void testGetDateInstance() {
        // 初始化 Date 对象
        Date date = new Date();

        DateFormat[] dateFormats = new DateFormat[8];
        for (int i = 0; i < locales.length; i++) {
            dateFormats[i * 4] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            dateFormats[i * 4 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            dateFormats[i * 4 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            dateFormats[i * 4 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);

        }
        for (int i = 0; i < locales.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("————中国的格式————");
                    break;
                case 1:
                    System.out.println("————美国的格式————");
                    break;
            }
            System.out.println("SHORT格式的日期：" + dateFormats[i * 4].format(date));
            System.out.println("MEDIUM格式的日期：" + dateFormats[i * 4 + 1].format(date));
            System.out.println("LONG格式的日期：" + dateFormats[i * 4 + 2].format(date));
            System.out.println("FULL格式的日期：" + dateFormats[i * 4 + 3].format(date));
        }
    }
}

