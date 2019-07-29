package com.spring.annotation.aop;

import com.spring.annotation.aop.service.IIntroductionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect("pertarget(target(com.spring.annotation.aop.service.IIntroductionService))")
public class PertargetAspect2 {
   
    private int counter = 1;
    

    @DeclareParents(value = "com.spring..IPointcutService+", defaultImpl = com.spring.annotation.aop.service.impl.IntroductiondService.class)
    private IIntroductionService introductionService;
    
    @Before(value = "execution(public * *(..))")
    public void executionTest1(JoinPoint jp) {
        System.out.println("============pertarget(target(cn.javass.spring.chapter6.service.IPointcutService)):" + counter++);
    }
    
}
