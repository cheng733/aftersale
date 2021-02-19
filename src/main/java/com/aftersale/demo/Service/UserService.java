package com.aftersale.demo.Service;

import com.aftersale.demo.Mapper.UserMapper;
import com.aftersale.demo.bean.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public User getUser(User user){
        User u  = userMapper.getUser(user);
        return u;
    }
    public int registerUser(User user){
        try {
            int u = userMapper.registerUser(user);
            return u;
        }catch (Exception e){

            return 0;

        }
    }
}
