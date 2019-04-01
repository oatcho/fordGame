package com.detroitlabs.fordgame.service;


import com.detroitlabs.fordgame.model.Boss;
import com.detroitlabs.fordgame.model.Pokemon;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Pokemonservice {

    public Pokemon fetchSinglePokemon(int pokemonID){
        System.setProperty("http.agent", "cheese");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + pokemonID, Pokemon.class);
    }

    public Boss fetchPokemonBoss(int pokemonID) {
        System.setProperty("http.agent", "cheese");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + pokemonID, Boss.class);
    }

}
