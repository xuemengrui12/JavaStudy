package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
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
