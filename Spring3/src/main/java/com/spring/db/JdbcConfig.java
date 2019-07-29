package com.spring.db;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by xmr on 2019/7/3.
 */

@Configuration//指定该类是一个配置类、等价于一个spring的配置文件
@ComponentScan("com.spring.db")
@PropertySource("classpath:resources.properties")
public class JdbcConfig {
    @Value("${db.driver.class}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String user;

    @Value("${db.password}")
    private String password;

    /**
     * Bean注解：该注解只能写在方法上，表明使用此方法创建一个对象，并且放入spring容器。
     * name属性：给当前@Bean注解方法创建的对象指定一个名称(即bean的id）。
     * @return
     */
    @Bean(name="dataSource")
    public DruidDataSource createDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean(name="jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DruidDataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
