package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IHelloWorldService;
import com.spring.annotation.aop.service.IIntroductionService;
import com.spring.annotation.aop.service.impl.HelloWorldService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:annotation/advice.xml"})
public class AopTest {
//@Autowired
private HelloWorldService helloworldService;

    /**
     * 前置通知
     */
    @Test
    public void testAnnotationBeforeAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
        helloworldService.sayBefore("before");
        System.out.println("======================================");
    }

    @Test
    public void testAnnotationAfterReturningAdvice() {
        System.out.println("======================================");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation/advice.xml");
        IHelloWorldService helloworldService = ctx.getBean("helloWorldService", IHelloWorldService.class);
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
