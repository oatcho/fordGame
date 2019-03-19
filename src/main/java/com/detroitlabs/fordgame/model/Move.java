package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Move {

    private ArrayList<PikachuMoves> name = new ArrayList<>();

    public ArrayList<PikachuMoves> getName() {
        return name;
    }

    public void setName(ArrayList<PikachuMoves> name) {
        this.name = name;
    }
}
