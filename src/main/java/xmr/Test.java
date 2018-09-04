package xmr;

/**
 * Created by xmr on 2018/6/22.
 */
public class Test {
    int a=10;
    public static void main(String[] args) {
        Test t1=new Test();
        Test t2=t1;
        t1.a=20;
        t1=null;
        String a=new String("ass");
        String b=new String("ass");
        System.out.println(a.equals(b));
        System.out.println();
//        System.out.println(t2.a);
//        LinkedHashMap
//        HashMap
    }

}
