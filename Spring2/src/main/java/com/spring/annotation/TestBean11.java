package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 构造器注入
 * 通过将@Autowired注解放在构造函数上来完成构造器注入，默认构造器参数通过类型自动装配
 */
public class TestBean11 {

    private String message;

    @Autowired(required = false)
    private TestBean11(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
