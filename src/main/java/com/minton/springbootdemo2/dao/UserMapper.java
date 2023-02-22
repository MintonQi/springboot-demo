package com.minton.springbootdemo2.dao;

import com.minton.springbootdemo2.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    String testUserMapper(User user);

    User selectById(int id);

    User selectByName(String username);


    int insertUser(User user);
//

}
