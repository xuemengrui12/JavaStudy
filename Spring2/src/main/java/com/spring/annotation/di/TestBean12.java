package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通过将@Autowired注解放在字段上来完成字段注入
 */
@Component
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
