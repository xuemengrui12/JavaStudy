package com.spring.annotation;

import com.spring.annotation.qualifier.Mysql;
import com.spring.annotation.qualifier.Oracle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

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
