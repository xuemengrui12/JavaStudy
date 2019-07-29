package com.spring.di;

import org.springframework.stereotype.Service;

/**
 * 使用@Service 声明Bean
 */
@Service
public class FunctionService {
	public String sayHello(String word){
		return "Hello " + word +" !"; 
	}

}
