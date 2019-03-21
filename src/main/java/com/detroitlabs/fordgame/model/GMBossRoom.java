package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class GMBossRoom extends Room {

    Boss gmBoss;

    public GMBossRoom() {
    }

    public GMBossRoom(String roomName, Boss gmBoss) {
        super(roomName);
        this.gmBoss = gmBoss;
    }

    @Override
    public String toString() {
        return "GMBossRoom{" +
                "roomName=" + super.getRoomName() +
                "gmBoss=" + gmBoss +
                '}';
    }

    public Boss getGmBoss() {
        return gmBoss;
    }

    public void setGmBoss(Boss gmBoss) {
        this.gmBoss = gmBoss;
    }
}
