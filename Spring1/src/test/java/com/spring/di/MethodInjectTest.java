package com.spring.di;

import com.spring.di.bean.Printer;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MethodInjectTest {
    
    @Test
    public void testLookup() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di/lookupMethodInject.xml");
        System.out.println("=======singleton sayHello======");
        HelloApi helloApi1 = context.getBean("helloApi1", HelloApi.class);
        helloApi1.sayHello();
        helloApi1 = context.getBean("helloApi1", HelloApi.class);
        helloApi1.sayHello();
        System.out.println("=======prototype sayHello======");
        HelloApi helloApi2 = context.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
        helloApi2 = context.getBean("helloApi2", HelloApi.class);
        helloApi2.sayHello();
    }
    
    @Test
    public void testMethodReplacer() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di/methodReplacerInject.xml");
        Printer printer = context.getBean("printer", Printer.class);
        printer.print("我将被替换");
    }
}

