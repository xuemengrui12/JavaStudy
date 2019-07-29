package com.spring.res;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;


/**
 * ResourceLoaderAware接口
 */
public class ResoureLoaderAwareTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("res/resourceLoaderAware.xml");
        ResourceBean resourceBean = ctx.getBean(ResourceBean.class);
        ResourceLoader loader = resourceBean.getResourceLoader();
        Assert.assertTrue(loader instanceof ApplicationContext);

        ResourceBean2 resourceBean2 = ctx.getBean(ResourceBean2.class);
        Assert.assertTrue(resourceBean2.getResourceLoader() instanceof ApplicationContext);
    }
}
