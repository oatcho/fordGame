package com.detroitlabs.fordgame.model;

public class FordRoom extends Room {

    private String onTime = "You successfully made it to work on time, You da man!!!";
    private String late = "You are late, I hope you have another job on deck fam";

    public FordRoom(String name, String onTime, String late) {
        super(name);
        this.onTime = onTime;
        this.late = late;
    }

    @Override
    public String toString() {
        return "FordRoom{" +
                "name=" + super.getRoomName() +
                "onTime='" + onTime + '\'' +
                ", late='" + late + '\'' +
                '}';
    }

    public String getOnTime() {
        return onTime;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }
}
