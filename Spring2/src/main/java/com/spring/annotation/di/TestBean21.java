package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBean21 {
    //注入其他 Bean属性
    @Value(value = "#{message}")
    private String message;

    public String getMessage() {
        return message;
    }
}
