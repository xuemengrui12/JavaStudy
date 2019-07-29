package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 构造器注入
 * 通过将@Autowired注解放在构造器上来完成构造器注入，
 * 默认构造器参数通过类型自动装配
 */
@Component
public class TestBean11 {
    
    private String message;
    
    @Autowired(required=false)
    private TestBean11(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
