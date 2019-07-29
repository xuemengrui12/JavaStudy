//实例工厂类
package com.spring.di;


public class HelloApiInstanceFactory {
    
    public HelloApi newInstance(String message, int index) {
        return new HelloImpl3(message, index);
    }
    
}
