package com.aftersale.demo.Controller;




import com.aftersale.demo.Service.ServiceFeeService;
import com.aftersale.demo.bean.ServiceFee;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServiceFeeController {
    @Autowired
    ServiceFeeService serviceFeeService;
    @PostMapping("/getServiceFee")
    public Msg getServiceFeeInfo(Integer offset, Integer size){
        Long total = serviceFeeService.getTotal();
//        if(!repairMan.equals("")){
//            List<ServiceFee> maintenDetailInfos = maintenDetailService.getMaintenDetailInfo(repairMan,offset,size);
//            if(maintenDetailInfos!=null){
//                return Msg.success().add("info","查询成功").add("result",maintenDetailInfos).add("total",total);
//            }else{
//                return Msg.fail().add("info","查询失败");
//            }
//        }else{
        List<ServiceFee> serviceFeeInfos = serviceFeeService.getServiceFeeInfoNO(offset,size);
        if(serviceFeeInfos!=null){
            return  Msg.success().add("info","查询成功").add("result",serviceFeeInfos).add("total",total);
        }else{
            return  Msg.fail().add("info","查询失败");
        }
//        }


    }
    @PostMapping("/insertServiceFee")
    public Msg insertServiceFeeInfo(String repairNum,String serviceMethod,String hours,String price,String manageFee,String otherFee,String feeTotal,String opinions){
        Integer id = serviceFeeService.insertServiceFeeInfo(repairNum,serviceMethod,hours,price,manageFee,otherFee,feeTotal,opinions);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    //    @PostMapping("/editStatusMaintenDetail")
//    public Msg updateMaintenDetailInfo(String id,String status){
//        Integer ids = maintenDetailService.updateMaintenDetailInfo(id,status);
//        if(!ids.equals("")&&ids!=0){
//            return Msg.success().add("info","修改成功").add("result",ids);
//        }else{
//            return Msg.fail().add("info","修改失败");
//        }
//    }
//    @PostMapping("/editProblemDescMaintenDetail")
//    public Msg updateDescMaintenDetailInfo(String id,String problemDesc){
//        Integer ids = maintenDetailService.updateDescMaintenDetailInfo(id,problemDesc);
//        if(!ids.equals("")&&ids!=0){
//            return Msg.success().add("info","修改成功").add("result",ids);
//        }else{
//            return Msg.fail().add("info","修改失败");
//        }
//    }
    @PostMapping("/delServiceFee")
    public Msg deleteServiceFeeInfo(String id){
        Integer integer = serviceFeeService.deleteServiceFeeInfo(id);
        if(!integer.equals("")&&integer!=0){
            return Msg.success().add("info","删除成功").add("result",integer);
        }else{
            return Msg.fail().add("info","删除失败");
        }
    }
}
