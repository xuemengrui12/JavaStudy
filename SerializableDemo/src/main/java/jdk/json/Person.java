package jdk.json;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

import java.io.Serializable;

/**
 * Created by xmr on 2019/10/31.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 775293629684513095L;
    @Protobuf(fieldType = FieldType.STRING,order = 1)
    private String name;
    @Protobuf(fieldType = FieldType.INT32,order = 2)
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
