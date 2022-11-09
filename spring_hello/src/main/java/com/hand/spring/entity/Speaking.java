package com.hand.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: 陈佳欢 jiahuan.chen@hand-china.com
 * @date: 2022.04.25
 */
@Data
@AllArgsConstructor
public class Speaking implements Cloneable{
    private String contains;
    private Hello hello;

    @Override
    public Speaking clone() throws CloneNotSupportedException {
        Speaking speaking = (Speaking) super.clone();
        speaking.setHello(null == this.hello? null : (Hello) this.hello.clone());
        return speaking;
    }
}
