package com.spring.db.service;

import com.spring.db.dao.IUserDao;
import com.spring.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xmr on 2019/6/13.
 */
@Service
public class UserService {
    @Autowired
    private IUserDao userDao;

    public void addUser(User user){
        userDao.add(user);
    }
}
