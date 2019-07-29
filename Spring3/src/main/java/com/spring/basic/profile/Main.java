package com.spring.basic.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		  AnnotationConfigApplicationContext context =
				  new AnnotationConfigApplicationContext();
		  
		  context.getEnvironment().setActiveProfiles("dev"); //将活动的profile设置为prod
		  context.register(ProfileConfig.class);
		  context.refresh(); //刷新容器
		  
	      DemoBean demoBean = context.getBean(DemoBean.class);
	      
	      System.out.println(demoBean.getContent());
	      
	      context.close();
	}
}
