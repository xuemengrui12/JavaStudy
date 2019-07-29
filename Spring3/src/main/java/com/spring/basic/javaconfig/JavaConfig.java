package com.spring.basic.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Java配置通过@Configuration和@Bean来实现
 */
@Configuration //声明为配置类
public class JavaConfig {
    @Bean //注解在方法上，声明返回值是一个Bean
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;

    }

//	@Bean
//	public UseFunctionService useFunctionService(FunctionService functionService){//4
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
}
