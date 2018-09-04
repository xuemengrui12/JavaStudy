package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 字段注入
 * 通过将@Autowired注解放在构造器上来完成字段注入
 */
public class TestBean12 {
    
    @Autowired
    private String message;
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
