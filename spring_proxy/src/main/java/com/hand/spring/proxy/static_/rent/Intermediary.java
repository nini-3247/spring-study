package com.hand.spring.proxy.static_.rent;

import com.hand.spring.proxy.entity.House;

public class Intermediary implements Rent{

    private Tenant tenant;

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @Override
    public void rentTo() {
        House house = new House(502);
        int money = 2000;
        seeAHouse(house);
        tenant.rentTo();
        charge(money);
    }

    public void seeAHouse(House house) {
        System.out.println("See a house: " + house.toString());
    }

    public void charge(int money) {
        System.out.println("Total fee is: " + money);
    }
}
