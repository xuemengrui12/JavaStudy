package com.spring.annotation.aop.service;

public interface IHelloWorldService {
    
     void sayHello();
    
     void sayBefore(String param);

     boolean sayAfterReturning();
    
     void sayAfterThrowing();

     boolean sayAfterFinally();
    
     void sayAround(String param);
    
     void sayAdvisorBefore(String param);
}
