package com.spring.res;

import junit.framework.TestCase;
import org.jboss.vfs.TempFileProvider;
import org.jboss.vfs.VFS;
import org.jboss.vfs.VirtualFile;
import org.jboss.vfs.spi.RealFileSystem;
import org.junit.Test;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * 内置Resource实现
 */
public class ResourceTest {


    /**
     * 使用ByteArrayResource处理byte数组资源
     */
    @Test
    public void testByteArrayResource() {
        Resource resource = new ByteArrayResource("Hello World!".getBytes());
        if (resource.exists()) {
            dumpStream(resource);
        }
        assertEquals(false, resource.isOpen());
    }

    /**
     * 使用ByteArrayInputStream处理字节流
     */
    @Test
    public void testInputStreamResource() {
        ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(bis);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println(resource.isOpen());
    }

    /**
     * 使用FileSystemResource处理File资源
     */
    @Test
    public void testFileResource() {
        File file = new File("d:/test.txt");
        Resource resource = new FileSystemResource(file);
        if (resource.exists()) {
            dumpStream(resource);
        }
        if (resource.exists()) {
            dumpStream(resource);
        }
        assertEquals(false, resource.isOpen());
    }
    /**
     * 使用默认的加载器加载资源，将加载当前ClassLoader类路径上相对于根路径的资源
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByDefaultClassLoader() throws IOException {
        Resource resource = new ClassPathResource("test1.properties");
//        Resource resource = new ClassPathResource("com/spring/res/test.properties");
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        assertEquals(false, resource.isOpen());
    }

    /**
     * 使用指定的ClassLoader进行加载资源，将加载指定的ClassLoader类路径上相对于根路径
     * 的资源
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByClassLoader() throws IOException {

//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//          System.out.println(loader.getResource("").getPath());
        ClassLoader cl = this.getClass().getClassLoader();
        Resource resource = new ClassPathResource("test1.properties", cl);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        assertEquals(false, resource.isOpen());
    }


    /**
     * 使用指定的类进行加载资源，将尝试加载相对于当前类的路径的资源
     * @throws IOException
     */
    @Test
    public void testClasspathResourceByClass() throws IOException {
        Class clazz = this.getClass();
        Resource resource1 = new ClassPathResource("/test1.properties", clazz);
        if (resource1.exists()) {
            dumpStream(resource1);
        }
        System.out.println("path:" + resource1.getFile().getAbsolutePath());
        assertEquals(false, resource1.isOpen());

        Resource resource2 = new ClassPathResource("/test1.properties", this.getClass());
        if (resource2.exists()) {
            dumpStream(resource2);
        }
        System.out.println("path:" + resource2.getFile().getAbsolutePath());
        assertEquals(false, resource2.isOpen());

    }

    /**
     * 加载jar包里的资源，首先在当前类路径下找不到，最后才到Jar包里找，而且在第一个Jar
     * 包里找到的将被返回
     * @throws IOException
     */
    @Test
    public void testClasspathResourceFromJar() throws IOException {
        Resource resource = new ClassPathResource("overview.html");
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getURL().getPath());
        assertEquals(false, resource.isOpen());

    }


    /**
     * 使用UrlResource简化URL资源访问
     * @throws IOException
     */
    @Test
    public void testUrlResource() throws IOException {
        Resource resource = new UrlResource("file:d:/test.txt");
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getURL().getPath());
        assertEquals(false, resource.isOpen());

        Resource resource2 = new UrlResource("http://www.baidu.com");
        if (resource2.exists()) {
            dumpStream(resource2);
        }
        System.out.println("path:" + resource2.getURL().getPath());
        assertEquals(false, resource2.isOpen());

    }


    @Test
    public void testVfsResource1() throws IOException {
        VirtualFile virtualFile = VFS.getChild("d:/test.txt");
        Resource resource = new VfsResource(virtualFile);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getURL().getPath());
        assertEquals(false, resource.isOpen());

    }

    /**
     * VFS访问物理文件系统
     * @throws IOException
     */
    @Test
    public void testVfsResourceForRealFileSystem() throws IOException {
        //1.创建一个虚拟的文件目录
        VirtualFile home = VFS.getChild("/home");
        //2.将虚拟目录映射到物理的目录
        VFS.mount(home, new RealFileSystem(new File("d:")));
        //3.通过虚拟目录获取文件资源
        VirtualFile testFile = home.getChild("test.txt");
        //4.通过一致的接口访问
        Resource resource = new VfsResource(testFile);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        TestCase.assertEquals(false, resource.isOpen());

    }

    /**
     * VFS访问jar包
     * @throws IOException
     */
    @Test
    public void testVfsResourceForJar() throws IOException {
        //1.首先获取jar包路径
        File realFile = new File("lib/spring-aop-4.1.5.RELEASE.jar");
        //2.创建一个虚拟的文件目录
        VirtualFile home = VFS.getChild("/home2");
        //3.将虚拟目录映射到物理的目录
        VFS.mountZipExpanded(realFile, home, TempFileProvider.create("tmp", Executors.newScheduledThreadPool(1)));
        //4.通过虚拟目录获取文件资源
        VirtualFile testFile = home.getChild("META-INF/spring.handlers");
        //5.通过一致的接口访问
        Resource resource = new VfsResource(testFile);
        if (resource.exists()) {
            dumpStream(resource);
        }
        System.out.println("path:" + resource.getFile().getAbsolutePath());
        assertEquals(false, resource.isOpen());

    }


    private void dumpStream(Resource resource) {
        InputStream is = null;
        try {
            //1.获取文件资源
            is = resource.getInputStream();
            //2.读取资源
            byte[] descBytes = new byte[is.available()];
            is.read(descBytes);
            System.out.println(new String(descBytes));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //3.关闭资源
                is.close();
            } catch (IOException e) {
            }
        }
    }

}
