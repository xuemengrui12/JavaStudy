package xmr.test;

import java.util.Date;

/**
 * Created by xmr on 2018/6/22.
 */
public class Test {
    int a = 10;
    public static void main(String[] args) {
        Test t1 = new Test();
//        Test t2 = t1;
//        t1.a = 20;
//        t1 = null;
//        List<String> list = new ArrayList<>();
//        String a = new String("ass");
//        String b = new String("ass");
//        System.out.println(a.equals(b));
//        System.out.println(t2.a);
//        t1.getResult1();
    }

    public void getResult1() {
        final int max = 707829217;
        int count = 0;
        boolean flag = true;
        for (int i = 2; i <= max; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
                flag = true;
            }
            if (flag) {
                System.out.println("质数是===="+i);
                count++;
            }
        }
        System.out.println("质数个数是：" + count);
    }
}
