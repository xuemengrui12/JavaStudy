package xmr;

/**
 * Created by xmr on 2018/9/25.
 */
public class ClassTest {

    public static void main(String[] args) {
        ClassOuter classOuter = new ClassOuter();
        ClassOuter.InnerClass innerClass = classOuter.new InnerClass();
        ClassOuter.StaticInnerClass staticInnerClass = new ClassOuter.StaticInnerClass();
        System.out.println(innerClass.getAge1());
        System.out.println(innerClass.getName1());
        System.out.println(ClassOuter.StaticInnerClass.getName2());
        System.out.println(staticInnerClass.getName3());


    }

}

/*只能使用default修饰*/
class ClassOuter {
    int age = 28;
    static String name = "xmr";

    public int getAge() {
        return age;
    }

    public static String getName() {
        return name;
    }

    /*方法名可与类名相同*/
    public void ClassOuter() {

    }


    /*内部类可使用所有修饰符
     * 非静态内部类不能有静态属性和静态方法*/
    public class InnerClass {
        int age1 = 27;

        /*而非静态内部类则可以访问外部类的所有成员（方法和属性）*/
        public int getAge1() {
            return getAge() + age;
        }

        public String getName1() {
            return ClassOuter.name;
        }
    }

    /*内部类可使用所有修饰符
     * 静态内部类中才能有静态属性和静态方法*/
    protected static class StaticInnerClass {
        int age = 28;
        static String name = "static class";

        /*静态内部类只能够访问外部类的静态成员和静态方法*/
        public static String getName2() {
            return getName() + ClassOuter.name;
        }

        public String getName3() {
            return getName() + ClassOuter.name;
        }
    }
}


