//静态工厂类
package com.spring.di;


public class HelloApiStaticFactory {
	
	public static HelloApi newInstance(String message, int index) {
		return new HelloImpl3(message, index);
	}
	
}
