package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
    String id;
    String name;
    String phone;
    String username;
    String password;
    String hireDate;
    String status;
    String role;
}
