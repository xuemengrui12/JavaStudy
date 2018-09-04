package com.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xmr on 2018/2/8.
 */
public class App {
    private static class InnerClz{

    }
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("test/beans1.xml");

        Some some = (Some) context.getBean("subBean");
        System.out.println(some.getMessage());
        System.out.println(some.getName());
        App.InnerClz clz1=new InnerClz();
        App.InnerClz clz2=new InnerClz();
        System.out.println(clz1.equals(clz2));
    }
}
