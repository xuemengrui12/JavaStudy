package com.spring.annotation.di;


import com.spring.annotation.di.qualifier.JSR330Mysql;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
@Component
public class TestBean51 {
    private DataSource mysqlDataSource;
    private DataSource oracleDataSource;

    @Inject
    public void initDataSoruce(@JSR330Mysql DataSource mysqlDataSource,
                               @Named("oracleDataSource") DataSource oracleDataSource) {
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
