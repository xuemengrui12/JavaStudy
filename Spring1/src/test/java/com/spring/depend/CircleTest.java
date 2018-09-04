package com.spring.depend;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环依赖
 */
public class CircleTest {

    public static void main(String[] args) {
//        new ClassPathXmlApplicationContext("depend/circleInjectByConstructor.xml");
//        new ClassPathXmlApplicationContext("depend/circleInjectBySetterAndSingleton.xml");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("depend/circleInjectBySetterAndPrototype.xml");
        System.out.println(ctx.getBean("circleA"));
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testcircleByConstructor() throws Throwable {
        try {
            new ClassPathXmlApplicationContext("depend/circleInjectByConstructor.xml");
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

    @Test
    public void testCircleBySetterAndSingleton1() throws Throwable {
        new ClassPathXmlApplicationContext("depend/circleInjectBySetterAndSingleton.xml");
    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleBySetterAndSingleton2() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
            ctx.setConfigLocation("depend/circleInjectBySetterAndSingleton.xml");
            ctx.refresh();
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }

    }

    @Test(expected = BeanCurrentlyInCreationException.class)
    public void circleBySetterAndPrototypeTest() throws Throwable {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("depend/circleInjectBySetterAndPrototype.xml");
            System.out.println(ctx.getBean("circleA"));
        }
        catch (Exception e) {
            //因为要在创建circle3时抛出；
            Throwable e1 = e.getCause().getCause().getCause();
            throw e1;
        }
    }

}

