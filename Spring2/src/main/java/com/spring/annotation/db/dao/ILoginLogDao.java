package com.spring.annotation.db.dao;


import com.spring.annotation.db.domain.LoginLog;

/**
 * Created by xmr on 2019/6/15.
 */
public interface ILoginLogDao {
    void insertLoginLog(LoginLog loginLog);
}
