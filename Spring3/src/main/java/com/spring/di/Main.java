package com.spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用依赖注入，声明Bean和注入Bean
 */
public class Main {
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(DiConfig.class); //1
		 
		 UseFunctionService useFunctionService = context.getBean(UseFunctionService.class); //2
		 
		 System.out.println(useFunctionService.sayHello("world"));

		context.close();
	}
}
