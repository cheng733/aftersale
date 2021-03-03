package com.aftersale.demo.Controller;

import com.aftersale.demo.Service.MaintenDetailService;
import com.aftersale.demo.bean.MaintenDetail;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaintenDetailController {
    @Autowired
    MaintenDetailService maintenDetailService;
    @PostMapping("/getMaintenDetail")
    public Msg getMaintenDetailInfo(String repairMan, Integer offset, Integer size){
        Long total = maintenDetailService.getTotal();
        if(!repairMan.equals("")){
            List<MaintenDetail> maintenDetailInfos = maintenDetailService.getMaintenDetailInfo(repairMan,offset,size);
            if(maintenDetailInfos!=null){
                return Msg.success().add("info","查询成功").add("result",maintenDetailInfos).add("total",total);
            }else{
                return Msg.fail().add("info","查询失败");
            }
        }else{
            List<MaintenDetail> maintenDetailInfos = maintenDetailService.getMaintenDetailInfoNO(offset,size);
            if(maintenDetailInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",maintenDetailInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
        }


    }
    @PostMapping("/insertMaintenDetailInfo")
    public Msg insertMaintenDetailInfo(String name,String price,String repairMan,String repairType,String repairNum,String managePrice,String repireDate,String faultDesc,String faultAnaly,String status){
        Integer id = maintenDetailService.insertMaintenDetailInfo(name,price,repairMan,repairType,repairNum,managePrice,repireDate,faultDesc,faultAnaly,status);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    @PostMapping("/editStatusMaintenDetail")
    public Msg updateMaintenDetailInfo(String repairNum,String status){
        Integer ids = maintenDetailService.updateMaintenDetailInfo(repairNum,status);
        if(!ids.equals("")&&ids!=0){
            return Msg.success().add("info","修改成功").add("result",ids);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }
    @PostMapping("/editProblemDescMaintenDetail")
    public Msg updateDescMaintenDetailInfo(String id,String problemDesc){
        Integer ids = maintenDetailService.updateDescMaintenDetailInfo(id,problemDesc);
        if(!ids.equals("")&&ids!=0){
            return Msg.success().add("info","修改成功").add("result",ids);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }
    @PostMapping("/delMaintenDetail")
    public Msg deleteMaintenDetailInfo(String id){
        Integer integer = maintenDetailService.deleteMaintenDetailInfo(id);
        if(!integer.equals("")&&integer!=0){
            return Msg.success().add("info","删除成功").add("result",integer);
        }else{
            return Msg.fail().add("info","删除失败");
        }
    }
}


