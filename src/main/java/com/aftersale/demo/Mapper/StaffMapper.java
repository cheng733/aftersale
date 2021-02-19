package com.aftersale.demo.Mapper;


import com.aftersale.demo.bean.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StaffMapper {
    /*
     * @Param name
     *
     * */
    @Select("select * from staffinfo where name like concat('%',#{name},'%') limit #{offset},#{size}")
    public List<Staff> getStaffInfo(@Param("name") String name, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from staffinfo")
    Long getTotal();
    @Select("select * from staffinfo limit #{offset},#{size}")
    public List<Staff> getStaffInfoNO(Integer offset,Integer size);
    @Update("update staffinfo set name=#{name},phone=#{phone},hireDate=#{hireDate},status=#{status},username=#{username},password=#{password},role=#{role} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateStaffInfo(Staff staff);
    @Insert("insert into staffinfo(name,phone,status,hireDate,username,password,role) values(#{name},#{phone},#{status},#{hireDate},#{username},#{password},#{role})")
    public Integer insertStaffInfo(String name,String phone,String status,String hireDate,String username,String password,String role);
    @Delete("delete from staffinfo where id=#{id}")
    public Integer deleteStaffInfo(String id);
}
