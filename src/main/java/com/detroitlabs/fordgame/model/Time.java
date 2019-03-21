package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

@Component
public class Time {

    private int time = 100;

    public Time() {

    }

    public void subtractTimeForQuiz() {
        time -= 1;
    }

    public void subtractTimeForBossBattle() {
        time -= 1;
    }

    public void subtractTimeForAction() {
        time -= 1;
    }

    public void addTimeForCorrectQuizAnswer() {
        time += 1;
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
