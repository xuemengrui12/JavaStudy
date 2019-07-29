package com.spring.annotation.aop.service.impl;


import com.spring.annotation.aop.service.IIntroductionService;

public class IntroductiondService implements IIntroductionService {
    @Override
    public void induct() {

        System.out.println("=========introduction");
    }

}
