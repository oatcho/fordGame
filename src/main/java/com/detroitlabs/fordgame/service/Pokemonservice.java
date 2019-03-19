package com.detroitlabs.fordgame.service;


import com.detroitlabs.fordgame.model.Pikachu;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Pokemonservice {

    public Pikachu fetchNidorino() {
        System.setProperty("http.agent", "pikachu");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "https://pokeapi.co/api/v2/" +
                        "pokemon/pikachu/", Pikachu.class);

    }
}
