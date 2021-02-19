package com.aftersale.demo.Service;

import com.aftersale.demo.Mapper.CarMaintenAppointMapper;
import com.aftersale.demo.bean.CarMaintenAppoint;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarMaintenAppointService {
    @Resource
    private  CarMaintenAppointMapper carMaintenAppointMapper;
    public Long getTotal(){
        Long total = carMaintenAppointMapper.getTotal();
        return total;
    }
    public List<CarMaintenAppoint> getCarMaintenAppointInfo(String name, Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
            List<CarMaintenAppoint> arrayList = carMaintenAppointMapper.getCarMaintenAppointInfo(name,offset,size);
            return arrayList;
        }

        return null;
    }
    public List<CarMaintenAppoint> getCarMaintenAppointInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<CarMaintenAppoint> customerInfos = carMaintenAppointMapper.getCarMaintenAppointInfoNO(offset,size);
            return  customerInfos;
        }
        return  null;
    }
    public Integer updateCarMaintenAppointInfo(String id,String status){
        try{
            Integer integer = carMaintenAppointMapper.updateCarMaintenAppointInfo(id,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer insertCarMaintenAppointInfo(String name,String phone,String card,String carNum,String helpTime,String faultArea,String faultDesc,String userRequire,String status){
        try{
            Integer integer = carMaintenAppointMapper.insertCarMaintenAppointInfo(name,phone,card,carNum,helpTime,faultArea,faultDesc,userRequire,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
//    public Integer deleteCustomerInfo(String id){
//        try{
//            Integer integer = carMaintenAppointMapper.deleteCustomerInfo(id);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
}
