package com.spring.db.dao.impl;

import com.spring.db.dao.ILoginLogDao;
import com.spring.db.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by xmr on 2019/6/15.
 */
@Repository
public class LoginLogDaoImpl  implements ILoginLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertLoginLog(LoginLog loginLog) {

    }
}
