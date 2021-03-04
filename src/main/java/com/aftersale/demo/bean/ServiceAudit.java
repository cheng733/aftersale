package com.aftersale.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ServiceAudit {
    String id;
    String repairNum;
    String verfiDepart;
    String returnMethod;
    String interviewee;
    String visitor;
    String userRequireAndSuggest;
    String returnConclusion;
    String status;
}
