package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IPointcutService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderAopTest {
    
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/order.xml");
        IPointcutService testService = ctx.getBean("pointcutService", IPointcutService.class);
        testService.test();
    }
}
