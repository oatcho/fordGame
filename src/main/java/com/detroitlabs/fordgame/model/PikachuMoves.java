package com.detroitlabs.fordgame.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class PikachuMoves {

    private String move;
    private Move moveName = new Move();

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @JsonProperty("name")
    public Move getMoveName() {
        return moveName;
    }

    @JsonProperty("name")
    public void setMoveName(Move moveName) {
        this.moveName = moveName;
    }
}
