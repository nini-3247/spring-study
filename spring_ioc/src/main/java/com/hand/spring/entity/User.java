package com.hand.spring.entity;

public class User {
    private String name;
    private int age;
    private boolean admin;
    private String nickName;

    public User(String name, int age, boolean admin, String nickName) {
        this.name = name;
        this.age = age;
        this.admin = admin;
        this.nickName = nickName;
    }

    public User(String name, int age, boolean admin) {
        this.name = name;
        this.age = age;
        this.admin = admin;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", admin=" + admin +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    /**
     * 偷个懒，没有重写hashcode方法
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        User userObj = (User) obj;
        return (this.age == userObj.age) &&
                (this.admin == userObj.admin) &&
                (this.name == null? userObj.name == null : this.name.equals(userObj.name)) &&
                (this.nickName == null? userObj.nickName == null : this.nickName.equals(userObj.nickName));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
