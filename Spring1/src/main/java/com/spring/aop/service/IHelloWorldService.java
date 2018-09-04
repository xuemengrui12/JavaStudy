package com.spring.aop.service;

/**
 * Created by xmr on 2018/3/20.
 */
public interface IHelloWorldService {
    //前置通知
    public void sayBefore(String param);

    //后置返回通知
    public boolean sayAfterReturning();

    //后置异常通知
    public void sayAfterThrowing();

    //后置最终通知
    public boolean sayAfterFinally();

    //环绕通知
    public void sayAround(String param);

    public void sayAdvisorBefore(String param);
}

