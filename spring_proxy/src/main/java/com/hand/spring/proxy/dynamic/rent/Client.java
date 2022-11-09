package com.hand.spring.proxy.dynamic.rent;

import lombok.Data;

@Data
public class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public void rentFrom(Rent rent) {
        rent.rentTo();
    }

}
