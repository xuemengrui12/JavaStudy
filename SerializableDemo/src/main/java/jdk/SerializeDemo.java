package jdk;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) {
        // 序列化操作
        SerializePerson();
        Person.sex = "F";
        //反序列化操作
        Person person = DeSerializePerson();

        System.out.println(person);

//        System.out.println(person.sex);
    }

    private static void SerializePerson() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person")));
            Person person = new Person();
            person.setAge(28);
            person.setName("xmr");
            oo.writeObject(person);
            oo.flush();
            System.out.println("序列化成功: " + new File("person").length());
            oo.writeObject(person);
            oo.flush();
            System.out.println("序列化成功: " + new File("person").length());
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person1 = (Person) ois.readObject();
//            person.setName("xx");
//            oo.writeObject(person);
//            oo.flush();

            Person person2 = (Person) ois.readObject();
            System.out.println(person1 == person2);

            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Person DeSerializePerson() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("person")));
            Person person = (Person) ois.readObject();
            ois.close();

            return person;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
