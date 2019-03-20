package com.detroitlabs.fordgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PikachuMoves {

   private ArrayList<Move> moves;


   @JsonProperty("move")
    public ArrayList<Move> getMoves() {
        return moves;
    }

    @JsonProperty("move")
    public void setMoves(ArrayList<Move> moves) {
        this.moves = moves;
    }



}
