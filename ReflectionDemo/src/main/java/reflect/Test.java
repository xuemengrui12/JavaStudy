package reflect;

/**
 * Created by xmr on 2018/8/26.
 */
public class Test {
    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;

        demo1 = new Test().getClass();
        demo2 = Test.class;
        try {
            //一般尽量采用这种形式
            demo3 = Class.forName("reflect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("类名称   " + demo1.getName());
        System.out.println("类名称   " + demo2.getName());
        System.out.println("类名称   " + demo3.getName());
        System.out.println("demo1=demo2" + " " + demo1.equals(demo2));
        System.out.println("demo1=demo3" + " " + demo1.equals(demo3));
        System.out.println("demo2=demo3" + " " + demo2.equals(demo3));
    }
}
