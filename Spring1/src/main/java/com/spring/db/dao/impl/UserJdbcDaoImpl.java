package com.spring.db.dao.impl;

import com.spring.db.UserModel;
import com.spring.db.dao.IUserDao;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserJdbcDaoImpl extends JdbcDaoSupport implements IUserDao {

    private static final String INSERT_SQL = "insert into test(name) values(:myName)";
    private static final String COUNT_ALL_SQL = "select count(*) from test";
    
    @Override
    public void save(UserModel model) {
        getJdbcTemplate().update(INSERT_SQL, new BeanPropertySqlParameterSource(model));
    }

    @Override
    public int countAll() {
        return getJdbcTemplate().update(COUNT_ALL_SQL);
    }
    
    
}
