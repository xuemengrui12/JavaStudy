package com.spring.annotation.aop.service.impl;


import com.spring.annotation.aop.service.IIntroductionService;
import org.springframework.stereotype.Service;

@Service
public class IntroductiondService implements IIntroductionService {
    
    @Override
    public void induct() {
        System.out.println("=========introduction");
    }
}
