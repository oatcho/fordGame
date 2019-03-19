package com.detroitlabs.fordgame.Model;

public class ChryslerBossRoom  extends Room {

    Boss chryslerBoss;

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
