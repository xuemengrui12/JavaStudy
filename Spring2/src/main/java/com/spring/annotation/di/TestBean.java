package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Required;

/**
 * Spring自带依赖注入注解
 */
public class TestBean {
    
    private String message;
    
    @Required
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
