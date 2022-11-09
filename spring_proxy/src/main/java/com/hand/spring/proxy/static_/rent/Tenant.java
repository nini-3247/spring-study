package com.hand.spring.proxy.static_.rent;

import lombok.Data;

@Data
public class Tenant implements Rent{
    private String name;

    public Tenant(String name) {
        this.name = name;
    }

    @Override
    public void rentTo() {
        System.out.println("Tenant: " + name + " is going to rent the house!");
    }
}
