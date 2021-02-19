package com.aftersale.demo.Service;


import com.aftersale.demo.Mapper.CustomerMapper;
import com.aftersale.demo.bean.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerMapper customerMapper;
    public Long getTotal(){
        Long total = customerMapper.getTotal();
        return total;
    }
    public List<Customer> getCustomerInfo(String name, Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
            List<Customer> arrayList = customerMapper.getCustomerInfo(name,offset,size);
            return arrayList;
        }

        return null;
    }
    public List<Customer> getCustomerInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<Customer> customerInfos = customerMapper.getCustomerInfoNO(offset,size);
            return  customerInfos;
        }
        return  null;
    }
    public Integer updateCustomerInfo(Customer customer){
        try{
            Integer integer = customerMapper.updateCustomerInfo(customer);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer insertCustomerInfo(String name,String phone,String status,String registerDate){
        try{
            Integer integer = customerMapper.insertCustomerInfo(name,phone,status,registerDate);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer deleteCustomerInfo(String id){
        try{
            Integer integer = customerMapper.deleteCustomerInfo(id);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
}
