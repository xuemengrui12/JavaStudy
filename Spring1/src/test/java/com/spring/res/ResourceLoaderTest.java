package com.spring.res;


import org.junit.Test;
import org.springframework.core.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ResourceLoader接口
 */
public class ResourceLoaderTest {
    
    @Test
    public void testResourceLoad() {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("classpath:com/spring/res/test1.txt");
        //验证返回的是ClassPathResource
        assertEquals(ClassPathResource.class, resource.getClass());
        
        Resource resource2 = loader.getResource("file:com/spring/res/test1.txt");
        //验证返回的是ClassPathResource
        assertEquals(FileUrlResource.class, resource2.getClass());
        
        Resource resource3 = loader.getResource("com/spring/res/test1.txt");
        //验证返默认可以加载ClasspathResource
        assertTrue(resource3 instanceof ClassPathResource);
        
    }
}
