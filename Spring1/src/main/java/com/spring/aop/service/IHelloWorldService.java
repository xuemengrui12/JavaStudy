package com.spring.aop.service;

/**
 * Created by xmr on 2018/3/20.
 */
public interface IHelloWorldService {

    //前置通知
    void sayBefore(String param);

    //后置返回通知
    boolean sayAfterReturning();

    //后置异常通知
    void sayAfterThrowing();

    //后置最终通知
    boolean sayAfterFinally();

    //环绕通知
    void sayAround(String param);

    void sayAdvisorBefore(String param);
}

