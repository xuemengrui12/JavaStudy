//静态工厂类
package com.spring.di;


public class DependencyInjectByStaticFactory {
	
	public static HelloApi newInstance(String message, int index) {
		return new HelloImpl3(message, index);
	}
	
}
