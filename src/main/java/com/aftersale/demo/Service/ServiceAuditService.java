package com.aftersale.demo.Service;


import com.aftersale.demo.Mapper.ServiceAuditMapper;
import com.aftersale.demo.bean.ServiceAudit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceAuditService {
    @Resource
    private ServiceAuditMapper serviceAuditMapper;
    public Long getTotal(){
        Long total = serviceAuditMapper.getTotal();
        return total;
    }
    //    public List<ServiceAudit> getMaintenDetailInfo(String repairMan, Integer offset, Integer size){
//        Long total = getTotal();
//        if(total>0){
//            List<ServiceAudit> arrayList = serviceFeeService.getMaintenDetailInfo(repairMan,offset,size);
//            return arrayList;
//        }
//
//        return null;
//    }
    public List<ServiceAudit> getServiceAuditInfoNO(Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
            List<ServiceAudit> serviceAuditInfos = serviceAuditMapper.getServiceAuditInfoNO(offset,size);
            return  serviceAuditInfos;
        }
        return  null;
    }
        public Integer updateServiceAuditInfo(String id,String status){
        try{
            Integer integer = serviceAuditMapper.updateServiceAuditInfo(id,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
//    public Integer updateDescMaintenDetailInfo(String id,String problemDesc){
//        try{
//            Integer integer = maintenDetailMapper.updateDescMaintenDetailInfo(id,problemDesc);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
    public Integer insertServiceAuditInfo(String repairNum,String verfiDepart,String returnMethod,String interviewee,String visitor,String userRequireAndSuggest,String returnConclusion,String status){
        try{
            Integer integer = serviceAuditMapper.insertServiceAudit(repairNum,verfiDepart,returnMethod,interviewee,visitor,userRequireAndSuggest,returnConclusion,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer deleteServiceAuditInfo(String id){
        try{
            Integer integer = serviceAuditMapper.deleteServiceAudit(id);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
}
