package com.aftersale.demo.Mapper;


import com.aftersale.demo.bean.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {
    /*
     * @Param name
     *
     * */
    @Select("select * from customerinfo where name like concat('%',#{name},'%') limit #{offset},#{size}")
    public List<Customer> getCustomerInfo(@Param("name") String name, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from customerinfo")
    Long getTotal();
    @Select("select * from customerinfo limit #{offset},#{size}")
    public List<Customer> getCustomerInfoNO(Integer offset,Integer size);
    @Update("update customerinfo set name=#{name},phone=#{phone},status=#{status},registerDate=#{registerDate} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateCustomerInfo(Customer customer);
    @Insert("insert into customerinfo(name,phone,status,registerDate) values(#{name},#{phone},#{status},#{registerDate})")
    public Integer insertCustomerInfo(String name,String phone,String status,String registerDate);
    @Delete("delete from customerinfo where id=#{id}")
    public Integer deleteCustomerInfo(String id);
}
