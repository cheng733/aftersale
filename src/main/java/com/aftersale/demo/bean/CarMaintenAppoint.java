package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarMaintenAppoint {
    String id;
    String card;
    String carNum;
    String name;
    String phone;
    String helpTime;
    String faultArea;
    String faultDesc;
    String userRequire;
    String status;
}
