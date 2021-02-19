package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MaintenDetail {
    String id;
    String repairMan;
    String repairType;
    String repairNum;
    String name;
    String price;
    String managePrice;
    String repireDate;
    String faultDesc;
    String faultAnaly;
    String approve;
    String problemDesc;
    String status;
}
