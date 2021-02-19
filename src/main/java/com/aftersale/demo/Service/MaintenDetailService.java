package com.aftersale.demo.Service;

import com.aftersale.demo.Mapper.MaintenDetailMapper;
import com.aftersale.demo.bean.MaintenDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaintenDetailService {
    @Resource
    private MaintenDetailMapper maintenDetailMapper;
    public Long getTotal(){
        Long total = maintenDetailMapper.getTotal();
        return total;
    }
    public List<MaintenDetail> getMaintenDetailInfo(String repairMan, Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
            List<MaintenDetail> arrayList = maintenDetailMapper.getMaintenDetailInfo(repairMan,offset,size);
            return arrayList;
        }

        return null;
    }
    public List<MaintenDetail> getMaintenDetailInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<MaintenDetail> customerInfos = maintenDetailMapper.getMaintenDetailInfoNO(offset,size);
            return  customerInfos;
        }
        return  null;
    }
        public Integer updateMaintenDetailInfo(String id,String status){
        try{
            Integer integer = maintenDetailMapper.updateMaintenDetailInfo(id,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer updateDescMaintenDetailInfo(String id,String problemDesc){
        try{
            Integer integer = maintenDetailMapper.updateMaintenDetailInfo(id,problemDesc);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer insertMaintenDetailInfo(String name,String price,String repairMan,String repairType,String repairNum,String managePrice,String repireDate,String faultDesc,String faultAnaly,String status){
        try{
            Integer integer = maintenDetailMapper.insertMaintenDetailInfo(name,price,repairMan,repairType,repairNum,managePrice,repireDate,faultDesc,faultAnaly,status);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer deleteMaintenDetailInfo(String id){
        try{
            Integer integer = maintenDetailMapper.deleteMaintenDetailInfo(id);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
}


