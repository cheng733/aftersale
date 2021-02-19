package com.aftersale.demo.Mapper;

import com.aftersale.demo.bean.MaintenDetail;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface MaintenDetailMapper {
    /*
     * @Param name
     *
     * */
    @Select("select * from serviceinfo where repairMan like concat('%',#{repairMan},'%') limit #{offset},#{size}")
    public List<MaintenDetail> getMaintenDetailInfo(@Param("repairMan") String repairMan, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from serviceinfo")
    Long getTotal();
    @Select("select * from serviceinfo limit #{offset},#{size}")
    public List<MaintenDetail> getMaintenDetailInfoNO(Integer offset,Integer size);
    @Update("update serviceinfo set status=#{status} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateMaintenDetailInfo(String id,String status);
    @Update("update serviceinfo set problemDesc=#{problemDesc} where id=#{id}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public Integer updateDescMaintenDetailInfo(String id,String problemDesc);
    @Insert("insert into serviceinfo(name,price,repairMan,repairType,repairNum,managePrice,repireDate,faultDesc,faultAnaly,status) values(#{name},#{price},#{repairMan},#{repairType},#{repairNum},#{managePrice},#{repireDate},#{faultDesc},#{faultAnaly},#{status})")
    public Integer insertMaintenDetailInfo(String name,String price,String repairMan,String repairType,String repairNum,String managePrice,String repireDate,String faultDesc,String faultAnaly,String status);
    @Delete("delete from serviceinfo where id=#{id}")
    public Integer deleteMaintenDetailInfo(String id);

}