package com.spring.basic.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
	@PostConstruct //@PostConstruct�ڹ��캯��ִ����֮��ִ��
    public void init(){
        System.out.println("jsr250-init-method");
    }
    public JSR250WayService() {
        super();
        System.out.println("��ʼ�����캯��-JSR250WayService");
    }
    @PreDestroy //@PreDestroy�� Bean����֮ǰִ��
    public void destroy(){
        System.out.println("jsr250-destory-method");
    }

}
