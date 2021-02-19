package com.aftersale.demo.Controller;


import com.aftersale.demo.Service.StaffService;
import com.aftersale.demo.bean.Staff;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    StaffService staffService;
    @PostMapping("/getStaffInfo")
    public Msg getCustomerInfo(String name, Integer offset, Integer size){
        Long total = staffService.getTotal();
        if(!name.equals("")){
            List<Staff> staffInfos = staffService.getStaffInfo(name,offset,size);
            if(staffInfos!=null){
                return Msg.success().add("info","查询成功").add("result",staffInfos).add("total",total);
            }else{
                return Msg.fail().add("info","查询失败");
            }
        }else{
            List<Staff> staffInfos = staffService.getStaffInfoNO(offset,size);
            if(staffInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",staffInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
        }


    }
    @PostMapping("/updateStaffInfo")
    public Msg updateUserInfo(Staff staff){
        Integer id = staffService.updateStaffInfo(staff);
        if(!id.equals("")&&id!=0){
            return Msg.success().add("info","修改成功").add("result",id);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }
    @PostMapping("/insertStaffInfo")
    public Msg insertUserInfo(String name,String phone,String status,String hireDate,String username,String password,String role){
        Integer id = staffService.insertStaffInfo(name,phone,status,hireDate,username,password,role);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    @PostMapping("/deleteStaffInfo")
    public Msg deleteUserInfo(String id){
        Integer integer = staffService.deleteStaffInfo(id);
        if(!integer.equals("")&&integer!=0){
            return Msg.success().add("info","删除成功").add("result",integer);
        }else{
            return Msg.fail().add("info","删除失败");
        }
    }
}