package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * 方法参数注入
 * 通过将@Autowired注解放在方法上来完成方法参数注入
 */
public class TestBean13 {
    
    private String message;

    @Autowired
    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
