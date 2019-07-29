package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
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
