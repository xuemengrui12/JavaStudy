package com.spring.aop;

import com.spring.aop.service.impl.HelloWorldService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderAopTest {
    
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/order.xml");
        HelloWorldService testService = ctx.getBean("helloWorldService", HelloWorldService.class);
        testService.sayAfterReturning();
    }
}
