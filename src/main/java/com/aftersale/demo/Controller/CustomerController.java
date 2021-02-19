package com.aftersale.demo.Controller;


import com.aftersale.demo.Service.CustomerService;
import com.aftersale.demo.bean.Customer;
import com.aftersale.demo.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/getCustomerInfo")
    public Msg getCustomerInfo(String name, Integer offset, Integer size){
        Long total = customerService.getTotal();
        if(!name.equals("")){
            List<Customer> customerInfos = customerService.getCustomerInfo(name,offset,size);
            if(customerInfos!=null){
                return Msg.success().add("info","查询成功").add("result",customerInfos).add("total",total);
            }else{
                return Msg.fail().add("info","查询失败");
            }
        }else{
            List<Customer> customerInfos = customerService.getCustomerInfoNO(offset,size);
            if(customerInfos!=null){
                return  Msg.success().add("info","查询成功").add("result",customerInfos).add("total",total);
            }else{
                return  Msg.fail().add("info","查询失败");
            }
        }


    }
    @PostMapping("/updateCustomerInfo")
    public Msg updateUserInfo(Customer customer){
        Integer id = customerService.updateCustomerInfo(customer);
        if(!id.equals("")&&id!=0){
            return Msg.success().add("info","修改成功").add("result",id);
        }else{
            return Msg.fail().add("info","修改失败");
        }
    }
    @PostMapping("/insertCustomerInfo")
    public Msg insertUserInfo(String name,String phone,String status,String registerDate){
        Integer id = customerService.insertCustomerInfo(name,phone,status,registerDate);
        if(id==1){
            return Msg.success().add("info","插入成功").add("result",id);
        }else{
            return Msg.fail().add("info","插入失败").add("result",id);
        }
    }
    @PostMapping("/deleteCustomerInfo")
    public Msg deleteUserInfo(String id){
        Integer integer = customerService.deleteCustomerInfo(id);
        if(!integer.equals("")&&integer!=0){
            return Msg.success().add("info","删除成功").add("result",integer);
        }else{
            return Msg.fail().add("info","删除失败");
        }
    }
}