package com.spring.annotation;

import com.spring.annotation.db.domain.User;
import com.spring.annotation.db.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xmr on 2019/7/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:annotation/dependecyInjectWithAnnotation.xml"})
public class JdbcTest {
    @Autowired
    private UserService userService;

    @Test
    public void insert() {
        User user = new User();
        user.setName("lily1");
        user.setSex("m");
        userService.insert(user);
    }
}
