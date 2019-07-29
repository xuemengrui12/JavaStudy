package com.spring.basic.javaconfig;

public class UseFunctionService {
	//没有使用@Autowired注解注入Bean
	FunctionService functionService;
	
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	
	public String sayHello(String word){
		return functionService.sayHello(word);
	}

}
