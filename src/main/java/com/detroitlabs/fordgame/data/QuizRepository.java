package com.detroitlabs.fordgame.data;

import com.detroitlabs.fordgame.model.Question;
import java.util.Arrays;
import java.util.List;

public class QuizRepository {
    public static final List<Question> ALL_TRUE_FALSE_QUESTIONS = Arrays.asList(
            new Question("True or False? Ford is the second largest family owned company in the world", "t"),
            new Question("True or False? In 2012, Chevrolet used a Ford SuperDuty to set up their Chevy Truck display at the Texas State Fair.", "t"),
            new Question("True or False? In 2018, the best selling vehicles in the United States were the Ford F-Series trucks.", "t")
    );

    public static final List<Question> ALL_MC_QUETIONS = Arrays.asList(
            new Question("Which scooter rental company did Ford recently acquire?\n" +
                    "a.) Spin \n" +
                    "b.) Lime \n" +
                    "c.) Bird \n" +
                    "d.) Fyre", "a"),
            new Question("How much did Ford purchase Michigan Central Station for? \n" +
                    "a.) $90 Million \n" +
                    "b.) $200 Million \n" +
                    "c.) $30 Million \n" +
                    "d.) $1 Billion", "a"),
            new Question("Who did Ford recently hire to be replace current CFO, Bob Shanks?\n" +
                    "a.) James Hackett \n" +
                    "b.) Abraham Lincoln \n" +
                    "c.) Paul Glomski \n" +
                    "d.) Tim Stone", "d")
    );

}
