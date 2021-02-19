package com.aftersale.demo.Mapper;

import com.aftersale.demo.bean.CarMaintenAppoint;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMaintenAppointMapper {
    /*
     * @Param name
     *
     * */
    @Select("select * from carmaintenappoint where name like concat('%',#{name},'%') limit #{offset},#{size}")
    public List<CarMaintenAppoint> getCarMaintenAppointInfo(@Param("name") String name, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from carmaintenappoint")
    Long getTotal();
    @Select("select * from carmaintenappoint limit #{offset},#{size}")
    public List<CarMaintenAppoint> getCarMaintenAppointInfoNO(Integer offset,Integer size);
    @Update("update carmaintenappoint set status=#{status} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateCarMaintenAppointInfo(String id,String status);
    @Insert("insert into carmaintenappoint(name,phone,card,carNum,helpTime,faultArea,faultDesc,userRequire,status) values(#{name},#{phone},#{card},#{carNum},#{helpTime},#{faultArea},#{faultDesc},#{userRequire},#{status})")
    public Integer insertCarMaintenAppointInfo(String name,String phone,String card,String carNum,String helpTime,String faultArea,String faultDesc,String userRequire,String status);
//    @Delete("delete from carmaintenappoint where id=#{id}")
//    public Integer deleteCustomerInfo(String id);
    
}
