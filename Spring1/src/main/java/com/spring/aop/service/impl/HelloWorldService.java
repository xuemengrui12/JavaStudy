package com.spring.aop.service.impl;

import com.spring.aop.service.IHelloWorldService;

/**
 * Created by xmr on 2018/3/20.
 */
public class HelloWorldService implements IHelloWorldService {

    //前置通知
    @Override
    public void sayBefore(String param) {
        System.out.println("============say " + param);
    }

    //后置返回通知
    @Override
    public boolean sayAfterReturning() {
        System.out.println("============after returning");
        return true;
    }

    //后置异常通知
    @Override
    public void sayAfterThrowing() {
        System.out.println("============before throwing");
        throw new RuntimeException();
    }

    //后置最终通知
    @Override
    public boolean sayAfterFinally() {
        System.out.println("============before finally");
        throw new RuntimeException();
    }
    //环绕通知
    @Override
    public void sayAround(String param) {
        System.out.println("============around param:" + param);
    }

    @Override
    public void sayAdvisorBefore(String param) {
        System.out.println("say============ " + param);
    }
}
