package com.detroitlabs.fordgame.model;

public class Boss {

    private String bossName;

    public Boss(String bossName) {
        this.bossName = bossName;

    }

    @Override
    public String toString() {
        return "Boss{" +
                "bossName='" + bossName + '\'' +
                '}';
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }
}
