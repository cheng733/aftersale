package com.aftersale.demo.Mapper;

import com.aftersale.demo.bean.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /*
    * @Param name
    *
    * */
    @Select("select * from userinfo where username like concat('%',#{username},'%') limit #{offset},#{size}")
    public List<UserInfo> getUserInfo(@Param("username") String username,@Param("offset") Integer offset,@Param("size") Integer size);
    @Select("select sum(1) from userinfo")
    Long getTotal();
    @Select("select * from userinfo limit #{offset},#{size}")
    public List<UserInfo> getUserInfoNO(Integer offset,Integer size);
    @Update("update userinfo set authorityInfo=#{authorityInfo} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateUserInfo(String id,String authorityInfo);
//    @Insert("insert into userinfo(username,password,phoneNumber,name,department) values(#{username},#{password},#{phoneNumber},#{name},#{department})")
//    public Integer insertUserInfo(String username,String password,String phoneNumber,String name,String department);
//    @Delete("delete from userinfo where id=#{id}")
//    public Integer deleteUserInfo(String id);
}
