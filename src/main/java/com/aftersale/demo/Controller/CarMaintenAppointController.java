package com.aftersale.demo.Controller;


import com.aftersale.demo.Service.CarMaintenAppointService;
import com.aftersale.demo.bean.CarMaintenAppoint;
import com.aftersale.demo.bean.Customer;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarMaintenAppointController {
    @Autowired
    CarMaintenAppointService carMaintenAppointService;
    @PostMapping("/getCarMaintenAppoint")
    public Msg getCarMaintenAppointInfo(String name, Integer offset, Integer size){
        Long total = carMaintenAppointService.getTotal();
        if(!name.equals("")){
            List<CarMaintenAppoint> carMaintenAppointInfos = carMaintenAppointService.getCarMaintenAppointInfo(name,offset,size);
            if(carMaintenAppointInfos!=null){
                return Msg.success().add("info","查询成功").add("result",carMaintenAppointInfos).add("total",total);
            }else{
                return Msg.fail().add("info","查询失败");
            }
        }else{
            List<CarMaintenAppoint> carMaintenAppointInfos = carMaintenAppointService.getCarMaintenAppointInfoNO(offset,size);
            if(carMaintenAppointInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",carMaintenAppointInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
        }


    }
    @PostMapping("/insertCarMaintenAppointInfo")
    public Msg insertCarMaintenAppointInfo(String name,String phone,String card,String carNum,String helpTime,String faultArea,String faultDesc,String userRequire,String status){
        Integer id = carMaintenAppointService.insertCarMaintenAppointInfo(name,phone,card,carNum,helpTime,faultArea,faultDesc,userRequire,status);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    @PostMapping("/editStatusMaintenAppoint")
    public Msg updateCarMaintenAppointInfo(String id,String status){
        Integer ids = carMaintenAppointService.updateCarMaintenAppointInfo(id,status);
        if(!ids.equals("")&&ids!=0){
            return Msg.success().add("info","修改成功").add("result",ids);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }

}
