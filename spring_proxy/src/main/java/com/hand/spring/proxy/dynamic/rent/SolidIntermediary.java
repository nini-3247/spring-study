package com.hand.spring.proxy.dynamic.rent;

public class SolidIntermediary implements Rent{

    @Override
    public void rentTo() {
        System.out.println("This is solid intermediary");
    }
}
