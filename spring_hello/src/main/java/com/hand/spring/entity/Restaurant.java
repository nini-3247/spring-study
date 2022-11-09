package com.hand.spring.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

/**
 * @author: 陈佳欢 jiahuan.chen@hand-china.com
 * @date: 2022.01.26
 */
@Getter
@Setter
@ToString
@FieldNameConstants
public class Restaurant {
    private String name;
    private Person owner;
    
//    public int year;
}
