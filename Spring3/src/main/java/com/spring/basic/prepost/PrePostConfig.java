package com.spring.basic.prepost;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.spring.basic.prepost")
public class PrePostConfig {
	//initMethod和 destroyMethod指定 BeanWayService类的init和 destroy方法在构造之后、Bean销毁之前执行。
	@Bean(initMethod="init",destroyMethod="destroy")
	BeanWayService beanWayService(){
		return new BeanWayService();
	}
	
	@Bean
	JSR250WayService jsr250WayService(){
		return new JSR250WayService();
	}

}
