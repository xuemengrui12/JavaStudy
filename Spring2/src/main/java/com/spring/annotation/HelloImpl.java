package com.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class HelloImpl  {

    public void sayHello() {
        System.out.println("Hello World!");
    }
    
}
