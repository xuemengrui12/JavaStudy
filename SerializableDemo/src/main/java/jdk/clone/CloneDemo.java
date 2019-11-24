package jdk.clone;

import java.io.IOException;


public class CloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        teacher.setName("xx");

        Student student = new Student();
        student.setName("xmr");
        student.setAge(35);
        student.setTeacher(teacher);

        Student student2 = (Student) student.deepClone(); //克隆一个对象
        student2.getTeacher().setName("jary");
        System.out.println(student);
        System.out.println(student2);


    }
}
