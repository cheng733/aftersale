package com.aftersale.demo.Service;

import com.aftersale.demo.Mapper.UserInfoMapper;
import com.aftersale.demo.bean.UserInfo;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    public Long getTotal(){
        Long total = userInfoMapper.getTotal();
        return total;
    }
    public List<UserInfo> getUserInfo(String username, Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
         List<UserInfo> arrayList = userInfoMapper.getUserInfo(username,offset,size);
        return arrayList;
        }

        return null;
    }
    public List<UserInfo> getUserInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<UserInfo> userInfos = userInfoMapper.getUserInfoNO(offset,size);
            return  userInfos;
        }
        return  null;
    }
    public Integer updateUserInfo(String id,String authorityInfo){
        try{
            Integer integer = userInfoMapper.updateUserInfo(id,authorityInfo);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
//    public Integer insertUserInfo(String username,String password,String phoneNumber,String name,String department){
//        try{
//            Integer integer = userInfoMapper.insertUserInfo(username,password,phoneNumber,name,department);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
//    public Integer deleteUserInfo(String id){
//        try{
//            Integer integer = userInfoMapper.deleteUserInfo(id);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
}
