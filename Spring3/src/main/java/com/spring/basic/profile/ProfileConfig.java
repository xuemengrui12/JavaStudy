package com.spring.basic.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @Profile既可以用到类级别也可以用到方法级别
 */
@Configuration
public class ProfileConfig {
	@Bean
	@Profile("dev") //Profile为dev时实例化devDemoBean
	public DemoBean devDemoBean() {
		return new DemoBean("from development profile");
	}

	@Bean
	@Profile("prod") ///Profile为prod时实例化prodDemoBean
	public DemoBean prodDemoBean() {
		return new DemoBean("from production profile");
	}

}
