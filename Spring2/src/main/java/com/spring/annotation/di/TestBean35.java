package com.spring.annotation.di;


import com.spring.annotation.di.qualifier.CustomQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class TestBean35 {
    
    private DataSource DataSource;
    
    @Autowired
    public TestBean35(@CustomQualifier("oracleDataSource") DataSource dataSource) {
        this.DataSource = dataSource;
    }
    
    public DataSource getDataSource() {
        return DataSource;
    }
}
