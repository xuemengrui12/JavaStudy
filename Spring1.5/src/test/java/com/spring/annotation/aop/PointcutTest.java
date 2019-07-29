package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IHelloWorldService;
import com.spring.annotation.aop.service.IPointcutService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.*;

public class PointcutTest {
    
    
    @Test
    public void test() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/pointcut.xml");
        IPointcutService testService = ctx.getBean("pointcutService", IPointcutService.class);
        IHelloWorldService helloService = ctx.getBean("helloService", IHelloWorldService.class);
        
        System.out.println("*********************************");
        testService.test();
        System.out.println("*********************************");
        testService.test("");
        
        System.out.println("*********************************");
        helloService.sayHello();
        System.out.println("*********************************");
        
        System.out.println("*********************************");
        testService.test(new Date());
        System.out.println("*********************************");
        
        System.out.println("*********************************");
        testService.test(new Model());
        System.out.println("*********************************");


        System.out.println("*********************************");
        testService.test("", "");
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new Model(), new Model());
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new HashMap());
        testService.test(new HashMap(), "");
        testService.test(new HashMap(), 1);
        System.out.println("*********************************");
        
        System.out.println("*********************************");
        testService.test(new ArrayList());
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new HashSet<IPointcutService.TestMap>());
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new Stack<Map>());
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new Serializable(){});
        System.out.println("*********************************");

        System.out.println("*********************************");
        testService.test(new Model());
        System.out.println("*********************************");

        System.out.println("*********************************");
        //用于测试@args 注意将掉用 public boolean test(Object obj);
        testService.test((Object)new Model());
        System.out.println("*********************************");

        System.out.println("======================================");
    }
    
    
}
