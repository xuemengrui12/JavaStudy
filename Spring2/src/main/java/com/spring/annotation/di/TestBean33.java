package com.spring.annotation.di;

import com.spring.annotation.di.qualifier.Mysql;
import com.spring.annotation.di.qualifier.Oracle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class TestBean33 {
    
    private DataSource mysqlDataSource;
    private DataSource oracleDataSource;
    
    @Autowired
    public void initDataSource(@Mysql DataSource mysqlDataSource, @Oracle DataSource oracleDataSource) {
        this.mysqlDataSource = mysqlDataSource;
        this.oracleDataSource = oracleDataSource;
    }
    
    public DataSource getMysqlDataSource() {
        return mysqlDataSource;
    }
    
    public DataSource getOracleDataSource() {
        return oracleDataSource;
    }
    
}
