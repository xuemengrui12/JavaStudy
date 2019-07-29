package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 任意一个或多个参数方法注入
 */
public class TestBean14 {

    private String message;
    
    private List<String> list;
    
    @Autowired(required = false)
    private void initMessage(String message, ArrayList<String> list) {
        this.message = message;
        this.list = list;
    }
    
    public String getMessage() {
        return message;
    }
    
    public List<String> getList() {
        return list;
    }
}
