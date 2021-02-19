package com.aftersale.demo.Mapper;
import com.aftersale.demo.bean.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM `user`WHERE username=#{username} AND password=#{password}")
    public User getUser(User user);
    @Insert("insert into user(username,password)values(#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int registerUser(User user);
}
