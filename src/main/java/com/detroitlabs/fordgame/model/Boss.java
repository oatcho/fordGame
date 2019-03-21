package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class Boss {

    private String bossName;

    public Boss() {
    }

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
