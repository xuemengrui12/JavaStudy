package com.spring.db.dao;

import com.spring.db.domain.LoginLog;

/**
 * Created by xmr on 2019/6/15.
 */
public interface ILoginLogDao {
    void insertLoginLog(LoginLog loginLog);
}
