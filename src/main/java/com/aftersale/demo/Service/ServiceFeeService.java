package com.aftersale.demo.Service;



import com.aftersale.demo.Mapper.ServiceFeeMapper;
import com.aftersale.demo.bean.ServiceFee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ServiceFeeService {
    @Resource
    private ServiceFeeMapper serviceFeeMapper;
    public Long getTotal(){
        Long total = serviceFeeMapper.getTotal();
        return total;
    }
//    public List<ServiceFee> getMaintenDetailInfo(String repairMan, Integer offset, Integer size){
//        Long total = getTotal();
//        if(total>0){
//            List<ServiceFee> arrayList = serviceFeeService.getMaintenDetailInfo(repairMan,offset,size);
//            return arrayList;
//        }
//
//        return null;
//    }
    public List<ServiceFee> getServiceFeeInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<ServiceFee> serviceFeeInfos = serviceFeeMapper.getServiceFeeInfoNO(offset,size);
            return  serviceFeeInfos;
        }
        return  null;
    }
//    public Integer updateServiceFeeInfo(String id,String status){
//        try{
//            Integer integer = serviceFeeService.updateMaintenDetailInfo(id,status);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
//    public Integer updateDescMaintenDetailInfo(String id,String problemDesc){
//        try{
//            Integer integer = maintenDetailMapper.updateDescMaintenDetailInfo(id,problemDesc);
//            return integer;
//        }catch (Exception e){
//            return 0;
//        }
//    }
    public Integer insertServiceFeeInfo(String repairNum,String serviceMethod,String hours,String price,String manageFee,String otherFee,String feeTotal,String opinions){
        try{
            Integer integer = serviceFeeMapper.insertServiceFee(repairNum,serviceMethod,hours,price,manageFee,otherFee,feeTotal,opinions);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer deleteServiceFeeInfo(String id){
        try{
            Integer integer = serviceFeeMapper.deleteServiceFee(id);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
}
