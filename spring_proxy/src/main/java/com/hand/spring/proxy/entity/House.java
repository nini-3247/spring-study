package com.hand.spring.proxy.entity;

import lombok.Data;

@Data
public class House {
    private String location;
    private String community;
    private int unit;
    private int number;

    public House(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "House{" +
                "location='" + location + '\'' +
                ", community='" + community + '\'' +
                ", unit=" + unit +
                ", number=" + number +
                '}';
    }
}
