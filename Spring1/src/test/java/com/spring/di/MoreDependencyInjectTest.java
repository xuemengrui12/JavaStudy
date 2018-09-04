package com.spring.di;

import com.spring.di.bean.DependentBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class MoreDependencyInjectTest {
    
    @Test
    public void testDependOn() throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("di/depends-on.xml");
        context.registerShutdownHook();//一定要注册销毁回调，否则我们定义的销毁方法不执行
        DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
        dependentBean.write("hello spring\n\t");
    }

}

