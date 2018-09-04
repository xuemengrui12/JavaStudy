package com.spring.annotation;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static junit.framework.Assert.*;

public class DependencyInjectWithAnnotationTest {
    private static String configLocation = "annotation/dependecyInjectWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

    //    Spring自带依赖注入注解
    @Test
    public void testRequiredForXmlSetterInject() {

        TestBean testBean = ctx.getBean("testBean", TestBean.class);
        System.out.println(testBean.getMessage());
    }


    @Test
    public void testAutowiredForConstructor() {
        TestBean11 testBean11 =  ctx.getBean("testBean11", TestBean11.class);
        System.out.println(testBean11.getMessage());
    }

    @Test
    public void testAutowiredForField() {
        TestBean12 testBean12 =  ctx.getBean("testBean12", TestBean12.class);
        System.out.println(testBean12.getMessage());
    }

    @Test
    public void testAutowiredForMethod() {
        TestBean13 testBean13 =  ctx.getBean("testBean13", TestBean13.class);
        assertEquals("hello", testBean13.getMessage());

        TestBean14 testBean14 =  ctx.getBean("testBean14", TestBean14.class);
        assertEquals("hello", testBean14.getMessage());
        assertEquals(ctx.getBean("list", List.class), testBean14.getList());
        System.out.println(testBean14.getList().toString());
    }

    @Test
    public void testValueInject() {
        TestBean21 testBean21 =  ctx.getBean("testBean21", TestBean21.class);
        assertEquals("hello", testBean21.getMessage());
        TestBean22 testBean22 =  ctx.getBean("testBean22", TestBean22.class);
        assertEquals("hello", testBean22.getMessage());
        System.out.println(testBean22.getMessage());
        TestBean23 testBean23 =  ctx.getBean("testBean23", TestBean23.class);
        assertEquals("hellohello", testBean23.getMessage());
    }

    @Test
    public void testQualifierInject1() {
        TestBean31 testBean31 =  ctx.getBean("testBean31", TestBean31.class);
        try {
            ctx.getBean("mysqlDataSource");//使用<qualifier>指定的标识符只能被@Qualifier使用
            fail();
        } catch (Exception e) {
            //找不到该Bean
            assertTrue(e instanceof NoSuchBeanDefinitionException);
        }

        assertEquals(ctx.getBean("mysqlDataSourceBean"), testBean31.getDataSource());
    }

//    @Test
//    public void testQualifierInject2() {
//        TestBean32 testBean32 = ctx.getBean("testBean32", TestBean32.class);
//        Assert.assertEquals(ctx.getBean("oracleDataSource"), testBean32.getDataSource());
//    }

//    @Test
//    public void testQualifierInject3() {
//        TestBean33 testBean33 = ctx.getBean("testBean33", TestBean33.class);
//        Assert.assertEquals(ctx.getBean("mysqlDataSourceBean"), testBean33.getMysqlDataSource());
//        Assert.assertEquals(ctx.getBean("oracleDataSource"), testBean33.getOracleDataSource());
//    }

//    @Test
//    public void testQualifierInject4() {
//        TestBean34 testBean34 = ctx.getBean("testBean34", TestBean34.class);
//        Assert.assertEquals(ctx.getBean("mysqlDataSourceBean"), testBean34.getMysqlDataSource());
//        Assert.assertEquals(ctx.getBean("oracleDataSource"), testBean34.getOracleDataSource());
//    }

//    @Test
//    public void testQualifierInject5() {
//        TestBean35 testBean35 = ctx.getBean("testBean35", TestBean35.class);
//        Assert.assertEquals(ctx.getBean("oracleDataSource"), testBean35.getDataSource());
//    }


    //2、JSR-250依赖注入注解
    @Test
    public void testResourceInject1() {
        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
        TestBean41 testBean41 =  ctx.getBean("testBean41", TestBean41.class);
        assertEquals("hello", testBean41.getMessage());
    }

//    //3、JSR-330依赖注入注解
//    @Test
//    public void testInject() {
//        TestBean51 testBean51 = ctx.getBean("testBean51", TestBean51.class);
//        Assert.assertEquals(ctx.getBean("mysqlDataSourceBean"), testBean51.getMysqlDataSource());
//        Assert.assertEquals(ctx.getBean("oracleDataSource"), testBean51.getOracleDataSource());
//    }

//    //4、JPA 依赖注入
//    @Test
//    public void testJpaInject() {
//        TestBean61 testBean61 = ctx.getBean("testBean61", TestBean61.class);
//        Assert.assertNotNull(testBean61.getEntityManager());
//        Assert.assertNotNull(testBean61.getEntityManagerFactory());
//    }
}
