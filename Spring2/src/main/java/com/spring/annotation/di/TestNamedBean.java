package com.spring.annotation.di;

import org.springframework.context.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Named;

@Named("namedBean")
public class TestNamedBean {
        
    @Inject
    private ApplicationContext ctx;
    
    public ApplicationContext getCtx() {
        return ctx;
    }
}
