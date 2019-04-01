package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class BossRoom extends Room {

    private Boss boss;

    public BossRoom() {
    }

    public BossRoom(String roomName, Boss boss) {
        super(roomName);
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "ChryslerBossRoom{" +
                "roomName=" + super.getRoomName() +
                "boss=" + boss +
                '}';
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
