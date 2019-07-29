package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Value
 * 放置在带@Autowired注解的方法的参数上
 */
public class TestBean22 {
    
    private String message;

    @Autowired
    public void initMessage(@Value(value = "#{message}") String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
