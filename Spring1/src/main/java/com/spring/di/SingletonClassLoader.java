package com.spring.di;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class SingletonClassLoader extends ClassLoader {
    
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //对于所有非com.spring包下的类使用父类加载
        if(!name.startsWith("com.spring")) {
            return super.loadClass(name);
        }
        try {
            //读取class文件资源
            InputStream is = new ClassPathResource(name.replace(".", "/") + ".class").getInputStream();
            int avaliable = is.available();
            byte[] bytes = new byte[avaliable];
            is.read(bytes, 0, avaliable);
            //定义类
            return defineClass(name, bytes, 0, avaliable);
        } catch (IOException e) {
            System.out.println(e);
            return super.loadClass(name);
        }
    }
}
