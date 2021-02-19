package com.aftersale.demo.interceptor;

import com.aftersale.demo.util.Msg;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class ParamInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o)throws Exception{
        String token = httpServletRequest.getHeader("token");
        if(token!=null){
            String id = stringRedisTemplate.opsForValue().get(token);
            if(id!=null){
                System.out.println("token验证成功");
                return true;
            }else{
                System.out.println("token验证失败");
                returnJson(httpServletResponse);
                return false;
            }
        }else{
            System.out.println("token验证失败");
            returnJson(httpServletResponse);
            return false;
        }
    }

    private void returnJson(HttpServletResponse response) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try{
            writer = response.getWriter();
            Msg msg = Msg.fail().add("info","没有token或token失效");
            JSONObject jsonObject = new JSONObject(msg);
            writer.print(jsonObject );
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (writer != null){
                writer.close();
            }
        }
    }

}
