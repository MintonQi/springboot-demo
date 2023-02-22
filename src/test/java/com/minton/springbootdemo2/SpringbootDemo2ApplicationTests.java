package com.minton.springbootdemo2;

import com.minton.springbootdemo2.dao.UserMapper;
import com.minton.springbootdemo2.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("hello springboot!");
        System.out.println(applicationContext);
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setEmail("xxx@xxx.com");
        System.out.println("--------------------------\n");


        User user1 = userMapper.selectByName("zhangsan");
        System.out.println(user1);
        System.out.println(userMapper.insertUser(user));
        System.out.println(userMapper.selectByName("test"));
        System.out.println("--------------------------\n");
    }
}
