package com.spring.senior.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.spring.senior.taskscheduler")
@EnableScheduling //开启对计划任务的支持。
public class TaskSchedulerConfig {

}
