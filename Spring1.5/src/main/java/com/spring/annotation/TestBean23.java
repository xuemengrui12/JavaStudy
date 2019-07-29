package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
/**
 * @Value
 * 放置在带@Autowired注解的构造器的参数上
 */
public class TestBean23 {
    
    private String message;
    
    @Autowired
    private TestBean23(@Value(value = "#{message}#{message}") String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
