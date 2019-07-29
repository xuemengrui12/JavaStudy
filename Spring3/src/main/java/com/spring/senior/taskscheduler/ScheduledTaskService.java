package com.spring.senior.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
	
	  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	  @Scheduled(fixedRate = 5000) //ͨ��@scheduled�����÷����Ǽƻ�����,ʹ��fixedRate����ÿ���̶�ʱ��ִ�С�
	  public void reportCurrentTime() {
	       System.out.println("ÿ������ִ��һ�� " + dateFormat.format(new Date()));
	   }

	//ʹ�� cron���Կɰ���ָ��ʱ��ִ��,����ָ����ÿ��1l��28��ִ��; cron��UNIX����UNIX( Linux)ϵͳ�µĶ�ʱ����
	  @Scheduled(cron = "0 28 11 ? * *"  )
	  public void fixTimeExecution(){
	      System.out.println("��ָ��ʱ�� " + dateFormat.format(new Date())+"ִ��");
	  }

}
