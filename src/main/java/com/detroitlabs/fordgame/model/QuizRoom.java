package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuizRoom extends Room {

    private List<Question> questions;

    public QuizRoom() {
    }

    public QuizRoom(String roomName) {
        super(roomName);
        this.questions = new ArrayList<Question>();
    }

    @Override
    public String toString() {
        return "QuizRoom{" +
                "questions=" + questions +
                '}';
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
