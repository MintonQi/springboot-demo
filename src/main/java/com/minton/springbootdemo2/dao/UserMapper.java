package com.minton.springbootdemo2.dao;

import com.minton.springbootdemo2.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    @Insert({
            "insert into user(username, password)" +
                    " values(#{userName}, #{password}"
    })
    int insertUser(User user);


}
