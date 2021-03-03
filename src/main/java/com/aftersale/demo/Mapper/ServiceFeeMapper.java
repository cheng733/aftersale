package com.aftersale.demo.Mapper;


import com.aftersale.demo.bean.ServiceFee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ServiceFeeMapper {
    /*
     * @Param name
     *
     * */
//    @Select("select * from serviceaudit where repairMan like concat('%',#{repairMan},'%') limit #{offset},#{size}")
//    public List<MaintenDetail> getMaintenDetailInfo(@Param("repairMan") String repairMan, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from servicefee")
    Long getTotal();
    @Select("select * from servicefee limit #{offset},#{size}")
    public List<ServiceFee> getServiceFeeInfoNO(Integer offset, Integer size);
    //    @Update("update serviceinfo set status=#{status} where id=#{id}")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    public Integer updateMaintenDetailInfo(String id,String status);
//    @Update("update serviceinfo set problemDesc=#{problemDesc} where id=#{id}")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    public Integer updateDescMaintenDetailInfo(String id,String problemDesc);
    @Insert("insert into servicefee(repairNum,serviceMethod,hours,price,manageFee,otherFee,feeTotal,opinions) values(#{repairNum},#{serviceMethod},#{hours},#{price},#{manageFee},#{otherFee},#{feeTotal},#{opinions})")
    public Integer insertServiceFee(String repairNum,String serviceMethod,String hours,String price,String manageFee,String otherFee,String feeTotal,String opinions);
    @Delete("delete from servicefee where id=#{id}")
    public Integer deleteServiceFee(String id);
}
