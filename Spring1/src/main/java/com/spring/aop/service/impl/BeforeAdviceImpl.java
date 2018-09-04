package com.spring.aop.service.impl;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeAdviceImpl implements MethodBeforeAdvice {
    
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("===========before advice");
    }
    
}
