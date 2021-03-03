package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ServiceFee {
    String id;
    String repairNum;
    String serviceMethod;
    String hours;
    String price;
    String manageFee;
    String otherFee;
    String feeTotal;
    String opinions;
}
