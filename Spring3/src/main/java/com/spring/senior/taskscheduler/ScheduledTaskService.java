package com.spring.senior.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
	
	  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	  @Scheduled(fixedRate = 5000) //通过@scheduled声明该方法是计划任务,使用fixedRate属性每隔固定时间执行。
	  public void reportCurrentTime() {
	       System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
	   }

	//使用 cron属性可按照指定时间执行,本例指的是每天1l点28分执行; cron是UNIX和类UNIX( Linux)系统下的定时任务。
	  @Scheduled(cron = "0 28 11 ? * *"  )
	  public void fixTimeExecution(){
	      System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
	  }

}
