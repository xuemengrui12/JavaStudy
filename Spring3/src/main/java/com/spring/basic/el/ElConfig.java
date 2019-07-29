package com.spring.basic.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.spring.basic.el")
@PropertySource("classpath:test.properties")//7
public class ElConfig {
	
	@Value("I Love You!") //ע����ͨ�ַ���
    private String normal;

	@Value("#{systemProperties['os.name']}") //ע�����ϵͳ����
	private String osName;
	
	@Value("#{ T(java.lang.Math).random() * 100.0 }") //ע����ʽ���
    private double randomNumber;

	@Value("#{demoService.another}") //ע������Bean����
	private String fromAnother;

	@Value("classpath:test.txt") //ע���ļ���Դ
//	@Value("classpath:com/spring/el/test.txt") //5
	private Resource testFile;

	@Value("http://www.baidu.com") //ע����ַ��Դ
	private Resource testUrl;

	@Value("${coder.name}") //ע�������ļ�
	private String bookName;

	@Autowired
	private Environment environment; //7
	
	@Bean //7
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	


	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(fromAnother);
			
//			System.out.println(IOUtils.toString(testFile.getInputStream()));
			System.out.println(IOUtils.toString(testUrl.getInputStream()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
