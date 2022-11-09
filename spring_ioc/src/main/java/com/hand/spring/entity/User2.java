package com.hand.spring.entity;

public class User2 {
    private String name;
    private String password;

    public User2() {
    }

    public User2(String name, String password) {
        this.name = name;
        this.password = password;
        System.out.println("In Constructor: " + toString());
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
