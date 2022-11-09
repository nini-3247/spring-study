package com.hand.spring.entity;

import java.util.*;

public class Hero {
    private String name;
    private Lover lover;
    private String[] friends;
    private List<String> family;
    private Map<String, Object> relations;
    private Set<String> achievements;
    private Properties info;
    private String ps;

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", lover=" + lover.toString() +
                ", friends=" + Arrays.toString(friends) +
                ", family=" + family +
                ", relations=" + relations +
                ", achievements=" + achievements +
                ", info=" + info +
                ", ps='" + ps + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lover getLover() {
        return lover;
    }

    public void setLover(Lover lover) {
        this.lover = lover;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public List<String> getFamily() {
        return family;
    }

    public void setFamily(List<String> family) {
        this.family = family;
    }

    public Map<String, Object> getRelations() {
        return relations;
    }

    public void setRelations(Map<String, Object> relations) {
        this.relations = relations;
    }

    public Properties getInfo() {
        return info;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    public Set<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<String> achievements) {
        this.achievements = achievements;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
