package com.spring.aop.service.impl;


import com.spring.aop.service.IIntroductionService;

public class IntroductiondService implements IIntroductionService {
    
    @Override
    public void induct() {
        System.out.println("=========introduction");
    }
}
