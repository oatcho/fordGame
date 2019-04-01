package com.detroitlabs.fordgame.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Boss extends Pokemon {

    public Boss() {
    }

    public Boss(String name, String weight, String base_experience, int id, PokemonSprite pokemonSprite, List<PokemonMoves> pokemonMoves, String moveChoice) {
        super(name, weight, base_experience, id, pokemonSprite, pokemonMoves, moveChoice);
    }

}
