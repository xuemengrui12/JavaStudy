package com.spring.annotation.di;

import com.spring.annotation.di.qualifier.DataBase;
import com.spring.annotation.di.qualifier.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class TestBean34 {
    
    private DataSource mysqlDataSource;
    private DataSource oracleDataSource;
    
    @Autowired
    public void initDataSource(
            @DataSourceType(ip="localhost", database= DataBase.MYSQL)
            DataSource mysqlDataSource,
            
            @DataSourceType(ip="localhost", database=DataBase.ORACLE) 
            DataSource oracleDataSource) {
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
