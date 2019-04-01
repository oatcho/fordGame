package com.detroitlabs.fordgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    private String name;
    private String weight;
    private String base_experience;
    private int id;
    private PokemonSprite pokemonSprite = new PokemonSprite();
    private List<PokemonMoves> pokemonMoves;
    private String moveChoice;

    public Pokemon() {
    }

    public Pokemon(String name, String weight, String base_experience, int id, PokemonSprite pokemonSprite, List<PokemonMoves> pokemonMoves, String moveChoice) {
        this.name = name;
        this.weight = weight;
        this.base_experience = base_experience;
        this.id = id;
        this.pokemonSprite = pokemonSprite;
        this.pokemonMoves = pokemonMoves;
        this.moveChoice = moveChoice;
    }

    @JsonProperty("sprites")
    public PokemonSprite getPokemonSprite() {
        return pokemonSprite;
    }

    @JsonProperty("sprites")
    public void setPokemonSprite(PokemonSprite pokemonSprite) {
        this.pokemonSprite = pokemonSprite;
    }

    @JsonProperty("moves")
    public List<PokemonMoves> getPokemonMoves() {
        return pokemonMoves;
    }

    @JsonProperty("moves")
    public void setPokemonMoves(List<PokemonMoves> pokemonMoves) {
        this.pokemonMoves = pokemonMoves;
    }

    public String getMoveChoice() {
        return moveChoice;
    }

    public void setMoveChoice(String moveChoice) {
        this.moveChoice = moveChoice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(String base_experience) {
        this.base_experience = base_experience;
    }
}
