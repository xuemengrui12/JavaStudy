package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面支持类
 * Created by xmr on 2018/3/20.
 */
public class HelloWorldAspect {
    //前置通知
    public void beforeAdvice(String param) {
        System.out.println("===========before advice param:" + param);
    }

    //后置返回通知
    public void afterReturningAdvice(Object retVal) {
        System.out.println("===========after returning advice retVal:" + retVal);
    }

    //后置异常通知
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("===========after throwing advice exception:" + exception);
    }

    //后置最终通知
    public void afterFinallyAdvice() {
        System.out.println("===========after finally advice");
    }

    //环绕通知
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("===========around before advice");
        Object retVal = pjp.proceed(new Object[]{"replace"});
        System.out.println("===========around after advice");
        return retVal;
    }

//    public void before(JoinPoint joinPoint) throws Throwable {
//    }
}
