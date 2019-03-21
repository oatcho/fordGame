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
    }

    @Test
    public void subtractTimeForAction() {
    }

    @Test
    public void addTimeForCorrectQuizAnswer() {
    }

    @Test
    public void checkForLateness() {
    }
}