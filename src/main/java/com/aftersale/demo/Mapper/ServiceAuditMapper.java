package com.aftersale.demo.Mapper;


import com.aftersale.demo.bean.ServiceAudit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ServiceAuditMapper {
    /*
     * @Param name
     *
     * */
//    @Select("select * from serviceaudit where repairMan like concat('%',#{repairMan},'%') limit #{offset},#{size}")
//    public List<MaintenDetail> getMaintenDetailInfo(@Param("repairMan") String repairMan, @Param("offset") Integer offset, @Param("size") Integer size);
    @Select("select sum(1) from serviceaudit")
    Long getTotal();
    @Select("select * from serviceaudit limit #{offset},#{size}")
    public List<ServiceAudit> getServiceAuditInfoNO(Integer offset, Integer size);
//    @Update("update serviceinfo set status=#{status} where id=#{id}")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    public Integer updateMaintenDetailInfo(String id,String status);
//    @Update("update serviceinfo set problemDesc=#{problemDesc} where id=#{id}")
//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    public Integer updateDescMaintenDetailInfo(String id,String problemDesc);
    @Insert("insert into serviceaudit(repairNum,verfiDepart,returnMethod,interviewee,visitor,userRequireAndSuggest,returnConclusion) values(#{repairNum},#{verfiDepart},#{returnMethod},#{interviewee},#{visitor},#{userRequireAndSuggest},#{returnConclusion})")
    public Integer insertServiceAudit(String repairNum,String verfiDepart,String returnMethod,String interviewee,String visitor,String userRequireAndSuggest,String returnConclusion);
    @Delete("delete from serviceaudit where id=#{id}")
    public Integer deleteServiceAudit(String id);
}
