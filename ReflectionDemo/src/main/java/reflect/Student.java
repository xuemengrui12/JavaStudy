package reflect;

/**
 * Created by xmr on 2018/8/26.
 */
public class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //（默认的构造函数）
    Student(String str) {
        System.out.println("(默认)的构造方法 str = " + str);
    }

    //无参构造函数
    public Student() {
    }

    //有一个参数的构造函数
    public Student(double age) {
        System.out.println("年龄：" + age);
    }

    //有多个参数的构造函数
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //受保护的构造函数
    protected Student(byte n) {
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造函数
    private Student(int age) {
        System.out.println("私有的构造方法，年龄：" + age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


}
