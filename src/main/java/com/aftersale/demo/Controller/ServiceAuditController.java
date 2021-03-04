package com.aftersale.demo.Controller;


import com.aftersale.demo.Service.ServiceAuditService;
import com.aftersale.demo.bean.ServiceAudit;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceAuditController {
    @Autowired
    ServiceAuditService serviceAuditService;
    @PostMapping("/getServiceAudit")
    public Msg getServiceAuditInfo(Integer offset, Integer size){
        Long total = serviceAuditService.getTotal();
//        if(!repairMan.equals("")){
//            List<ServiceAudit> maintenDetailInfos = maintenDetailService.getMaintenDetailInfo(repairMan,offset,size);
//            if(maintenDetailInfos!=null){
//                return Msg.success().add("info","查询成功").add("result",maintenDetailInfos).add("total",total);
//            }else{
//                return Msg.fail().add("info","查询失败");
//            }
//        }else{
            List<ServiceAudit> serviceAuditInfos = serviceAuditService.getServiceAuditInfoNO(offset,size);
            if(serviceAuditInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",serviceAuditInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
//        }


    }
    @PostMapping("/insertServiceAudit")
    public Msg insertServiceAuditInfo(String repairNum,String verfiDepart,String returnMethod,String interviewee,String visitor,String userRequireAndSuggest,String returnConclusion,String status){
        Integer id = serviceAuditService.insertServiceAuditInfo(repairNum,verfiDepart,returnMethod,interviewee,visitor,userRequireAndSuggest,returnConclusion,status);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    @PostMapping("/editStatusServiceAudit")
    public Msg updateServiceAuditInfo(String id,String status){
        Integer ids = serviceAuditService.updateServiceAuditInfo(id,status);
        if(!ids.equals("")&&ids!=0){
            return Msg.success().add("info","修改成功").add("result",ids);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }
//    @PostMapping("/editProblemDescMaintenDetail")
//    public Msg updateDescMaintenDetailInfo(String id,String problemDesc){
//        Integer ids = maintenDetailService.updateDescMaintenDetailInfo(id,problemDesc);
//        if(!ids.equals("")&&ids!=0){
//            return Msg.success().add("info","修改成功").add("result",ids);
//        }else{
//            return Msg.fail().add("info","修改失败");
//        }
//    }
    @PostMapping("/delServiceAudit")
    public Msg deleteServiceAuditInfo(String id){
        Integer integer = serviceAuditService.deleteServiceAuditInfo(id);
        if(!integer.equals("")&&integer!=0){
            return Msg.success().add("info","删除成功").add("result",integer);
        }else{
            return Msg.fail().add("info","删除失败");
        }
    }
}
