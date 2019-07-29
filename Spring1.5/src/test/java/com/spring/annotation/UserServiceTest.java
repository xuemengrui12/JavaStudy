package com.spring.annotation;

import com.spring.annotation.db.domain.User;
import com.spring.annotation.db.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * UserService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>ÁùÔÂ 13, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:annotation/application*.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    //    private static String configLocation = "classpath:annotation/applicationContext.xml";
//    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(configLocation);
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: addUser(User user)
     */
    @Test
    public void testAddUser() throws Exception {
//        userService= (UserService) ctx.getBean("userService");
//TODO: Test goes here...
        User user = new User();
        user.setName("lucy");
        user.setSex("f");
        userService.addUser(user);
    }


} 
