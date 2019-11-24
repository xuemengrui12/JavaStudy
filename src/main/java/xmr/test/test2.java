package xmr.test;

/**
 * Created by Administrator on 2017/2/10.
 */
public class test2 extends test1 {
    @Override
    public void method1() {
        System.out.print("ttttttttt");
    }

    public static void main(String[] args) {
        test2 t=new test2();
        t.method1();
        t.method2();
    }
}
