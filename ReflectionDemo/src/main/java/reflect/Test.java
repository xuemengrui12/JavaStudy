package reflect;

/**
 * Created by xmr on 2018/8/26.
 * 在Java程序中获得Class对象通常有如下三种方式：
 * 1、Object ——> getClass();该方法是java.lang.Object类中的一个方法，所以所有的Java对象都可以调用该方法
 * 2、任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3、通过Class类的静态方法forName（String  className）
 */
public class Test {
    public static void main(String[] args) {

        Class<?> demo1;
        Class<?> demo2;
        Class<?> demo3 = null;

        demo1 = new Test().getClass();
        demo2 = Test.class;
        try {
            //一般尽量采用这种形式
            demo3 = Class.forName("reflect.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("通过一个对象获得完整的包名和类名   " + demo1.getName());
        System.out.println("类名称   " + demo2.getName());
        System.out.println("类名称   " + demo3.getName());
        System.out.println("demo1=demo2" + " " + demo1.equals(demo2));
        System.out.println("demo1=demo3" + " " + demo1.equals(demo3));
        System.out.println("demo2=demo3" + " " + demo2.equals(demo3));

        Class c1 = int.class;//int的类类型
        Class c2 = String.class;//String的类类型
        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());//不包含包名的类类型
    }
}
