package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class Time {

    private int time = 8;

    public Time() {

    }

    public int subtractTimeForQuiz() {
        return time -= 1;
    }

    public int addTimeForBeatingBoss() { return time += 1; }

    public int subtractTimeForBossBattle() { return time -= 1; }

    public int subtractTimeForAction() {
        return time -= 1;
    }

    public int addTimeForCorrectQuizAnswer() {
        return time += 1;
    }

    public String checkForLateness() {
        if (time < 10) {
            return "You are late for work, kick rocks fam!";
        } else {
            return "Eta You Made It!!! (Drake Voice)";
        }
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                '}';
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
