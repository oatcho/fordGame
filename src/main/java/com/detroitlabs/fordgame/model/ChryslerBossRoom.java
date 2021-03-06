package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class ChryslerBossRoom  extends Room {

    Boss chryslerBoss;

    public ChryslerBossRoom() {
    }

    public ChryslerBossRoom(String roomName, Boss chryslerBoss) {
        super(roomName);
        this.chryslerBoss = chryslerBoss;
    }

    @Override
    public String toString() {
        return "ChryslerBossRoom{" +
                "roomName=" + super.getRoomName() +
                "chryslerBoss=" + chryslerBoss +
                '}';
    }

    public Boss getChryslerBoss() {
        return chryslerBoss;
    }

    public void setChryslerBoss(Boss chryslerBoss) {
        this.chryslerBoss = chryslerBoss;
    }
}
