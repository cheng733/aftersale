package com.aftersale.demo.Controller;

import com.aftersale.demo.Service.UserService;
import com.aftersale.demo.bean.User;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/login")
    public Msg login(User user){
        User u = userService.getUser(user);
        if(u != null){
            String token = UUID.randomUUID().toString().replaceAll("-","");
            stringRedisTemplate.opsForValue().set(token, String.valueOf(u.getId()), 3600, TimeUnit.SECONDS);//将用户的ID信息存入redis缓存，并设置一小时的过期时间
            return Msg.success().add("token",token).add("info","登录成功");
        }else{
            return  Msg.fail().add("info","登录失败");
        }
    }
    @PostMapping("/register")
    public Msg Register(User user){
        Integer id = userService.registerUser(user);
        if(!id.equals("")&&id!=0){
            return Msg.success().add("info","注册成功");
        }else{
            return Msg.fail().add("info","注册失败");
        }

    }
}
