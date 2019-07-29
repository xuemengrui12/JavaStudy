package com.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {
	@Autowired //使用@Autowired将FunctionService的实体Bean注入
	FunctionService functionService;
	
	public String sayHello(String word){
		return functionService.sayHello(word);
	}

}
