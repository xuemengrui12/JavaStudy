package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by xmr on 2019/6/10.
 */
public class StudentTest {
    public static void main(String[] args) throws Throwable {

        Class<?> demo = null;
        try {
            demo = Class.forName("reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Student student = null;
        try {
            student = (Student) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        student.setAge(28);
        System.out.println(student);

        //取得父类
        Class<?> temp = demo.getSuperclass();
        System.out.println("继承的父类为：   " + temp.getName());


        //通过类装载器获取Student类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("reflect.Student");
        //获取类的默认构造器对象并通过它实例化Student
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Student student1 = (Student) constructor.newInstance();
        //通过反射方法设置属性
        Method setAge=clazz.getMethod("setAge",int.class);
        setAge.invoke(student1,29);
        Method setName=clazz.getMethod("setName",String.class);
        setName.invoke(student1,"sss");
        System.out.println(student1.toString());
    }
}
