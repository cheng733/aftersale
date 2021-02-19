package com.aftersale.demo.Controller;

import com.aftersale.demo.Service.UserInfoService;
import com.aftersale.demo.bean.UserInfo;
import com.aftersale.demo.util.Msg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @PostMapping("/getUserInfo")
    public Msg getUserInfo(String username,Integer offset,Integer size){
        Long total = userInfoService.getTotal();
        if(!username.equals("")){
            List<UserInfo> userInfos = userInfoService.getUserInfo(username,offset,size);
            if(userInfos!=null){
                return Msg.success().add("info","查询成功").add("result",userInfos).add("total",total);
            }else{
                return Msg.fail().add("info","查询失败");
            }
        }else{
            List<UserInfo> userInfos = userInfoService.getUserInfoNO(offset,size);
            if(userInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",userInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
        }


    }
    @PostMapping("/editAuthorityInfo")
    public Msg updateUserInfo(String id,String authorityInfo){
       Integer ids = userInfoService.updateUserInfo(id,authorityInfo);
       if(!ids.equals("")&&ids!=0){
          return Msg.success().add("info","修改成功").add("result",ids);
       }else{
          return Msg.fail().add("info","修改失败");
       }
    }
//    @PostMapping("/insertUserInfo")
//    public Msg insertUserInfo(String username,String password,String phoneNumber,String name,String department){
//        Integer id = userInfoService.insertUserInfo(username,password,phoneNumber,name,department);
//        if(id==1){
//            return Msg.success().add("info","插入用户成功").add("result",id);
//        }else{
//           return Msg.fail().add("info","插入用户失败").add("result",id);
//        }
//    }
//    @PostMapping("/deleteUserInfo")
//    public Msg deleteUserInfo(String id){
//        Integer integer = userInfoService.deleteUserInfo(id);
//        if(!integer.equals("")&&integer!=0){
//           return Msg.success().add("info","删除用户成功").add("result",integer);
//        }else{
//            return Msg.fail().add("info","删除失败");
//        }
//    }
}
