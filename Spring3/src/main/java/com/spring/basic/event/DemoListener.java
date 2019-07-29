package com.spring.basic.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * �¼�������
 * ʵ�� ApplicationListener�ӿ�, ��ָ���������¼�����
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	/**
	 * @param event
	 * ʹ�� onApplicationEvent��������Ϣ���н��ܴ���
	 */
	public void onApplicationEvent(DemoEvent event) {
		
		String msg = event.getMsg();
		
		System.out.println("��(bean-demoListener)���ܵ���bean-demoPublisher��������Ϣ:"
				+ msg);

	}

}
