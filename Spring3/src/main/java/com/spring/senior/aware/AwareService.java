package com.spring.senior.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * ʵ�� BeanNameAware�� ResourceLoaderAware�ӿ�,��� Bean,���ƺ���Դ���صķ���
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader loader;

    /**
     * ʵ�� ResourceLoaderAware����д setResourceLoader
     *
     * @param resourceLoader
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    /**
     * ʵ�� BeanNameAware����д setBeanName����
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void outputResult() {
        System.out.println("Bean������Ϊ��" + beanName);

        Resource resource =
//				loader.getResource("classpath:test.txt");
                loader.getResource("/test.txt");
        try {

            System.out.println("ResourceLoader���ص��ļ�����Ϊ: " + IOUtils.toString(resource.getInputStream()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
