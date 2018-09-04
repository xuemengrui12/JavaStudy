package com.spring.annotation;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Value
 * 用于注入SpEL表达式，可以放置在字段方法或参数上
 */
public class TestBean21 {
    
    @Value(value = "#{message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
