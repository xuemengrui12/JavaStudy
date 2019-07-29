package com.spring.annotation;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentDefinitionWithAnnotationTest {

    private static String configLocation = "annotation/componentDefinitionWithAnnotation.xml";
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);

    @Test
    public void testComponent() {
        TestCompoment component = ctx.getBean("component", TestCompoment.class);
        TestCase.assertNotNull(component.getCtx());
    }
//
//    @Test
//    public void testDao() {
//        TestHibernateDaoImpl dao = ctx.getBean("testHibernateDao", TestHibernateDaoImpl.class);
//        Assert.assertNotNull(dao);
//    }

//    @Test
//    public void testService() {
//        TestServiceImpl service = ctx.getBean("testService", TestServiceImpl.class);
//        Assert.assertNotNull(service.getDao());
//    }

//    @Test
//    public void testWeb() {
//        TestAction action = ctx.getBean("testAction", TestAction.class);
//        Assert.assertNotNull(action);
//    }
    
//    @Test
//    public void testCache() {
//        TestCache cache = ctx.getBean("cache", TestCache.class);
//        Assert.assertNotNull(cache);
//    }

//    @Test
//    public void testManagedBean() {
//        TestManagedBean testManagedBean = ctx.getBean("managedBean", TestManagedBean.class);
//        Assert.assertNotNull(testManagedBean.getCtx());
//    }
//    @Test
//    public void testNamedBean() {
//        TestNamedBean testNamedBean = ctx.getBean("namedBean", TestNamedBean.class);
//        Assert.assertNotNull(testNamedBean.getCtx());
//    }

    @Test
    public void testFilter() {
//        TestBean14 testBean14 = ctx.getBean("testBean14", TestBean14.class);
//        Assert.assertNotNull(testBean14);
    }

}
