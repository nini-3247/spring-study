package com.hand.spring.proxy.dynamic.rent;

public class LargeIntermediary implements Rent{

    @Override
    public void rentTo() {
        System.out.println("This is large intermediary");
    }
}
