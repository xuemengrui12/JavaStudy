package com.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component("component")
//@Lazy(true)
//@Scope("singleton")
//@Qualifier("component")
//@Primary
@Component
public class TestCompoment {
        
    @Autowired
    private ApplicationContext ctx;
    
    public ApplicationContext getCtx() {
        return ctx;
    }
}
