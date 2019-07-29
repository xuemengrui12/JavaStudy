package com.spring.senior.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 实现 BeanNameAware、 ResourceLoaderAware接口,获得 Bean,名称和资源加载的服务
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    /**
     * 实现 ResourceLoaderAware需重写 setResourceLoader
     *
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    /**
     * 实现 BeanNameAware需重写 setBeanName方法
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void outputResult() {
        System.out.println("Bean的名称为：" + beanName);

        Resource resource =
//				loader.getResource("classpath:test.txt");
                loader.getResource("/test.txt");
        try {

            System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
