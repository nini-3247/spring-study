package com.hand.spring.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: 陈佳欢 jiahuan.chen@hand-china.com
 * @date: 2022.10.13
 */
@Data
public class Animal {
    private String speciesName;
    private List<Cat> cats;
}
