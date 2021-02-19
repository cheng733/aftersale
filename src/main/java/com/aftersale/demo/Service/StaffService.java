package com.aftersale.demo.Service;



import com.aftersale.demo.Mapper.StaffMapper;
import com.aftersale.demo.bean.Staff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StaffService {
    @Resource
    private StaffMapper staffMapper;
    public Long getTotal(){
        Long total = staffMapper.getTotal();
        return total;
    }
    public List<Staff> getStaffInfo(String name, Integer offset, Integer size){
        Long total = getTotal();
        if(total>0){
            List<Staff> arrayList = staffMapper.getStaffInfo(name,offset,size);
            return arrayList;
        }

        return null;
    }
    public List<Staff> getStaffInfoNO(Integer offset,Integer size){
        Long total = getTotal();
        if(total>0){
            List<Staff> staffInfos = staffMapper.getStaffInfoNO(offset,size);
            return  staffInfos;
        }
        return  null;
    }
    public Integer updateStaffInfo(Staff staff){
        try{
            Integer integer = staffMapper.updateStaffInfo(staff);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer insertStaffInfo(String name,String phone,String status,String hireDate,String username,String password,String role){
        try{
            Integer integer = staffMapper.insertStaffInfo(name,phone,status,hireDate,username,password,role);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
    public Integer deleteStaffInfo(String id){
        try{
            Integer integer = staffMapper.deleteStaffInfo(id);
            return integer;
        }catch (Exception e){
            return 0;
        }
    }
}

