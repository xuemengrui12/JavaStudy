package com.spring.annotation;

import com.spring.annotation.aop.service.IPointcutService;
import com.spring.annotation.di.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:annotation/dependecyInjectWithAnnotation.xml"})
public class DependencyInjectWithAnnotationTest {
    
    private static String configLocation = "classpath:annotation/dependecyInjectWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

//    @Autowired
//    private TestBean testBean;
    @Autowired
    private TestBean11 testBean11;
    @Autowired
    private TestBean12 testBean12;
    @Autowired
    private TestBean13 testBean13;
    @Autowired
    private TestBean14 testBean14;
    @Autowired
    private TestBean21 testBean21;
    @Autowired
    private TestBean22 testBean22;
    @Autowired
    private TestBean23 testBean23;
    @Autowired
    private TestBean31 testBean31;
    @Autowired
    private TestBean32 testBean32;
    @Autowired
    private TestBean33 testBean33;
    @Autowired
    private TestBean34 testBean34;
    @Autowired
    private TestBean35 testBean35;
    @Autowired
    private TestBean41 testBean41;
    @Autowired
    private TestBean51 testBean51;
//    @Autowired
//    private TestBean61 testBean61;

    //1、Spring自带依赖注入注解
//    @Test
//    public void testRequiredForXmlSetterInject() {
//        TestBean testBean = ctx.getBean("testBean", TestBean.class);
//
//        assertEquals("hello", testBean.getMessage());
//    }

    @Autowired
    private IPointcutService pointcutService;
    @Test
    public void test() {
        pointcutService.test();
    }
    @Test
    public void testAutowiredForConstructor() {
        assertEquals("hello", testBean11.getMessage());
    }

    @Test
    public void testAutowiredForField() {
        assertEquals("hello", testBean12.getMessage());
    }

    @Test
    public void testAutowiredForMethod() {
        assertEquals("hello", testBean13.getMessage());

        assertEquals("hello", testBean14.getMessage());
//        assertEquals(ctx.getBean("list", List.class), testBean14.getList());
    }

    @Test
    public void testValueInject() {
        assertEquals("hello", testBean21.getMessage());
        assertEquals("hellohello", testBean22.getMessage());
        assertEquals("hellohello", testBean23.getMessage());
        System.out.println(testBean21.getMessage());
        System.out.println(testBean22.getMessage());
        System.out.println(testBean23.getMessage());
    }

    @Test
    public void testQualifierInject1() {
        try {
            Object clzss=ctx.getBean("mysqlDataSource");//使用<qualifier>指定的标识符只能被@Qualifier使用
            System.out.println("clzss"+clzss.getClass().getName());
            fail();
        } catch (Exception e) {
            //找不到该Bean
            assertTrue(e instanceof NoSuchBeanDefinitionException);
        }
        System.out.println(ctx.getBean("mysqlDataSourceBean").getClass().getName());
        System.out.println(testBean31.getDataSource().getClass().getName());
    }

    @Test
    public void testQualifierInject2() {
        System.out.println(ctx.getBean("oracleDataSource"));
        System.out.println(testBean32.getDataSource());
    }

    @Test
    public void testQualifierInject3() {
        System.out.println(testBean33.getMysqlDataSource());
        System.out.println(testBean33.getOracleDataSource());
        System.out.println(ctx.getBean("mysqlDataSourceBean"));
        System.out.println(ctx.getBean("oracleDataSource"));
    }

    @Test
    public void testQualifierInject4() {
        System.out.println(testBean34.getMysqlDataSource());
        System.out.println(testBean34.getOracleDataSource());
        System.out.println(ctx.getBean("mysqlDataSourceBean"));
        System.out.println(ctx.getBean("oracleDataSource"));
    }

    @Test
    public void testQualifierInject5() {
        System.out.println(testBean35.getDataSource());
        System.out.println(ctx.getBean("oracleDataSource"));
    }


    //2、JSR-250依赖注入注解
    @Test
    public void testResourceInject1() {
        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
        assertEquals("hello", testBean41.getMessage());
    }

    //3、JSR-330依赖注入注解
    @Test
    public void testInject() {
        System.out.println(testBean51.getMysqlDataSource());
        System.out.println(testBean51.getOracleDataSource());
        System.out.println(ctx.getBean("mysqlDataSourceBean"));
        System.out.println(ctx.getBean("oracleDataSource"));
    }

    //4、JPA 依赖注入
//    @Test
//    public void testJpaInject() {
//        assertNotNull(testBean61.getEntityManager());
//        assertNotNull(testBean61.getEntityManagerFactory());
//    }
}
