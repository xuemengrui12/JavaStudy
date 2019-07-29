package com.spring.senior.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConifg {
	@Bean
    @Conditional(WindowsCondition.class) //通过@Conditional注解, 符合 Windows条件则实例化 windowsListService
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class) //通过@Conditional注解, 符合 Linux条件则实例化LinuxListservice
    public ListService linuxListService() {
        return new LinuxListService();
    }

}
