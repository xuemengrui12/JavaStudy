package com.spring.db.dao;


import com.spring.db.domain.User;

import java.util.List;

public interface IUserDao {

    void save(User user);

    int countAll();

    /*增*/
    int add(User user);

    /*删*/
    int delete(Integer uid);

    /*改*/
    int update(User user);

    /*查所有*/
    List<User> getAll();

    /*查一个*/
    User getById(Integer id);
}
