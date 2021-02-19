package com.aftersale.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Page<T> {
    private Integer page;
    private Integer size;
    private Long total;
}
