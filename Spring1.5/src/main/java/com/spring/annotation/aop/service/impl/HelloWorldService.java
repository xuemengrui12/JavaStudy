package com.spring.annotation.aop.service.impl;


import com.spring.annotation.aop.service.IHelloWorldService;

/**
 * Created by xmr on 2018/3/20.
 */
//@Service
public class HelloWorldService implements IHelloWorldService {

//    @Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }
    //前置通知切入点
    @Override
    public void sayBefore(String param) {
        System.out.println("============say " + param);
    }

    //后置返回通知切入点
    @Override
    public boolean sayAfterReturning() {
        System.out.println("============after returning");
        return true;
    }

    //后置异常通知切入点
    @Override
    public void sayAfterThrowing() {
        System.out.println("============before throwing");
        throw new RuntimeException();
    }

    //后置最终通知切入点
    @Override
    public boolean sayAfterFinally() {
        System.out.println("============before finally");
        throw new RuntimeException();
    }

    //环绕通知切入点
    @Override
    public void sayAround(String param) {
        System.out.println("============around param:" + param);
    }

    //引入切入点
    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("say============ " + param);
    }
}
