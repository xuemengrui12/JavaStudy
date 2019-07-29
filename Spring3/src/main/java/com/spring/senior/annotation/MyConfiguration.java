package com.spring.senior.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //组合@Configuration元注解。
@ComponentScan //组合@ComponentScan元注解
public @interface MyConfiguration {
	
	String[] value() default {}; //覆盖value参数

}
