package com.spring.annotation;


import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class TestBean32 {
    
    private DataSource DataSource;
    
    @Autowired
    //指定Bean标识符
    //@Qualifier(value = "mysqlDataSourceBean") //是错误的注入，不会发生回退容错，因为你指定了<qualifier>
    public void setDataSource(DataSource DataSource) {
        this.DataSource = DataSource;
    }
    
    public DataSource getDataSource() {
        return DataSource;
    }
}
