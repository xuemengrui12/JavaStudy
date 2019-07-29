package com.spring.aop;

import com.spring.aop.service.IHelloWorldService;
import com.spring.aop.service.IIntroductionService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AopTest {


    /**
     * 前置通知
     */
    @Test
    public void testSchemaBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayBefore("before");
        System.out.println("======================================");
    }

    /**
     * 后置返回通知
     */
    @Test
    public void testSchemaAfterReturningAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterReturning();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testSchemaAfterThrowingAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterThrowing();
        System.out.println("======================================");
    }

    /**
     * 后置最终通知
     */
    @Test(expected = RuntimeException.class)
    public void testSchemaAfterFinallyAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterFinally();
        System.out.println("======================================");
    }

    @Test
    public void testSchemaAroundAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAround("haha");
        System.out.println("======================================");
    }

    @Test
    public void testSchemaIntroduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }

    @Test
    public void testSchemaAdvisor() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAdvisorBefore("haha");
        System.out.println("======================================");
    }
    



}
