package com.spring.di;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * HelloImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>二月 26, 2018</pre>
 */
public class HelloImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sayHello()
     */
    @Test
    public void testSayHello() throws Exception {
//        System.out.println(System.getProperty("java.classpath"));
        //1、读取配置文件实例化一个IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("di/helloworld.xml");
        //2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
//        HelloApi helloApi = context.getBean("hello", HelloApi.class);
        HelloApi helloApi = context.getBean(HelloApi.class);
        //3、执行业务逻辑
        helloApi.sayHello();
    }


} 
