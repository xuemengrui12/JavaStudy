package xmr;

import java.lang.reflect.Field;

/**
 * Created by xmr on 2019/10/29.
 */
public class IntegerTest {
    public static void main(String[] args) {

//        Integer a = 1, b = 2;
        Integer a = 180, b = 182;
        System.out.println(a==b);
        //Integer a = 1相当于Integer a = Integer.valueOf(1)
        System.out.println("before : a=" + a + " b=" + b);
        swap(a, b);
//        swap1(a, b);
        System.out.println("after : a=" + a + " b=" + b);

    }

    private static void swap(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }

    private static void swap1(Integer a, Integer b) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
//            int temp = a.intValue();
//            field.set(a, b.intValue());
//            field.set(b,temp);

            //正确的做法
            Integer temp = Integer.valueOf(a.intValue()).intValue();
            field.set(a, b.intValue());
            field.set(b,temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
