package com.spring.annotation.db.service;

import com.spring.annotation.db.dao.IUserDao;
import com.spring.annotation.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xmr on 2019/7/8.
 */
@Service
public class UserService {
    @Autowired
    private IUserDao userDao;

    public int insert(User user) {
       return userDao.insert(user);
    }

}
