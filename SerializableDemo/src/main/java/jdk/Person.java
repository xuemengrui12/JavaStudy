package jdk;

import java.io.Serializable;

/**
 * Created by xmr on 2019/10/31.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 775293629684513095L;
    private String name;
    private int age;
    public static String sex = "M";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
