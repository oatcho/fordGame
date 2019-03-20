package com.detroitlabs.fordgame.model;

public class GMBossRoom extends Room {

    Boss gmBoss;

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
