package com.hand.spring.entity;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author: 陈佳欢 jiahuan.chen@hand-china.com
 * @date: 2022.07.05
 */
@Data
@FieldNameConstants
public class Father extends Person{
    private String name;
}
