package com.detroitlabs.fordgame.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TimeTest {

    private Time time;

    @Before
    public void setUp() {
        time = new Time();
    }

    @Test
    public void subtractTimeForQuiz() {
        int expectedTimeLeft = 99;
        int resultOfMethodCall = time.subtractTimeForQuiz();

        assertThat(expectedTimeLeft, equalTo(resultOfMethodCall));
    }

    @Test
    public void subtractTimeForBossBattle() {
        int expectedTimeLeft = 99;
        int resultOfMethodCall = time.subtractTimeForBossBattle();

        assertThat(expectedTimeLeft, equalTo(resultOfMethodCall));
    }

    @Test
    public void subtractTimeForAction() {
        int expectedTimeLeft = 99;
        int resultOfMethodCall = time.subtractTimeForAction();

        assertThat(expectedTimeLeft, equalTo(resultOfMethodCall));
    }

    @Test
    public void addTimeForCorrectQuizAnswer() {
        int expectedTimeLeft = 101;
        int resultOfMethodCall = time.addTimeForCorrectQuizAnswer();

        assertThat(expectedTimeLeft, equalTo(resultOfMethodCall));
    }

    @Test
    public void checkForLateness() {
        String expectedSting = "Eta You Made It!!! (Drake Voice)";
        String resultOfMethodCall = time.checkForLateness();

        assertThat(expectedSting, equalTo(resultOfMethodCall));
    }

    @Test
    public void addTimeForBeatingBoss() {
        int expectedTimeLeft = 101;
        int resultOfMethodCall = time.addTimeForBeatingBoss();

        assertThat(expectedTimeLeft, equalTo(resultOfMethodCall));
    }
}