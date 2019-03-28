package com.detroitlabs.fordgame.data;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class QuizRepositoryTest {

    QuizRepository quizRepository;

    @Before
    public void setUp() {
        quizRepository = new QuizRepository();
    }

    @Test
    public void checkTrueFalseAnswer() {
        String intendedAnswer = "Correct!";
        String methodCall = quizRepository.checkTrueFalseAnswer("f");

        assertThat(intendedAnswer, equalTo(methodCall));
    }
}