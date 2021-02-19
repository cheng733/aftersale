package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    String id;
    String name;
    String phone;
    String status;
    String registerDate;
}
