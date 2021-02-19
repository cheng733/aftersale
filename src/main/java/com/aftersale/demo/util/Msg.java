package com.aftersale.demo.util;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int status;
    private String message;
    private Map<String,Object> data = new HashMap<String,Object>();
    public static Msg success(){
        Msg result = new Msg();
        result.setStatus(200);
        result.setMessage("处理成功");
        return  result;
    }
    public static Msg fail(){
        Msg result = new Msg();
        result.setStatus(400);
        result.setMessage("处理失败");
        return  result;
    }
    public static Msg error(){
        Msg result = new Msg();
        result.setStatus(500);
        result.setMessage("服务器错误，请联系技术人员");
        return  result;
    }
    public Msg add(String key,Object value){
        this.data.put(key,value);
        return  this;
    }
    private void setMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
    private void setStatus(int status) {
        this.status = status;
    }
    public int getStatus(){
        return  status;
    }
    public Map<String,Object> getData(){
        return data;
    }
    public void setData(Map<String,Object> data){
        this.data = data;
    }
}
