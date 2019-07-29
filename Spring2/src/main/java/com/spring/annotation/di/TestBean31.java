package com.spring.annotation.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class TestBean31 {
    
    private DataSource DataSource;

    //根据<qualifier>标签指定Bean标识符
    @Autowired
    public void initDataSource(@Qualifier("mysqlDataSource") DataSource DataSource) {
        this.DataSource = DataSource;
    }
    
    public DataSource getDataSource() {
        return DataSource;
    }
    
}
