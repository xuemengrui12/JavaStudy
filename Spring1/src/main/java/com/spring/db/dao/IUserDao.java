package com.spring.db.dao;


import com.spring.db.UserModel;

public interface IUserDao {
    
    public void save(UserModel model);

    public int countAll();
}
