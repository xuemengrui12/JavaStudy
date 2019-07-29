package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IHelloWorldService;
import com.spring.annotation.aop.service.IIntroductionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:annotation/dependecyInjectWithAnnotation.xml"})
public class AopTest {
    @Autowired
    private IHelloWorldService helloworldService;
    @Test
    public void testHelloworld() {
        helloworldService.sayHello();
//        Assert.assertTrue(AopUtils.isAopProxy(helloworldService));
    }

    @Test
    public void testAnnotationAfterReturningAdvice() {
        System.out.println("======================================");
        helloworldService.sayAfterReturning();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterThrowingAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterThrowing();
        System.out.println("======================================");
    }

    @Test(expected = RuntimeException.class)
    public void testAnnotationAfterFinallyAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAfterFinally();
        System.out.println("======================================");
    }

    @Test
    public void testAnnotationAroundAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayAround("haha");
        System.out.println("======================================");
    }

    /**
     * 通过引入为目标对象引入新的接口
     */
    @Test
    public void testAnnotationIntroduction() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IIntroductionService introductionService = ctx.getBean("helloWorldService", IIntroductionService.class);
        introductionService.induct();
        System.out.println("======================================");
    }

}
