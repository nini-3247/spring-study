package com.hand.spring.entity;

public class Hello implements Cloneable{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Hello() {
    }

    public Hello(String value) {
        this.value = value;
    }
}
