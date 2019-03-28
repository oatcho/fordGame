package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.model.GameState;
import com.detroitlabs.fordgame.model.Pokemon;
import com.detroitlabs.fordgame.model.PokemonMoves;
import com.detroitlabs.fordgame.model.PokemonSprite;
import com.detroitlabs.fordgame.service.Pokemonservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    Pokemonservice pokemonservice;

    @RequestMapping("/")
    public String displayPokemon(ModelMap modelMap) {
        Pokemon pikachu = pokemonservice.fetchSinglePokemon(25);
//        Pokemon graveler

        Pokemon graveler = pokemonservice.fetchSinglePokemon(75);

        PokemonSprite pokemonSprite = pikachu.getPokemonSprite();
        List<PokemonMoves> pokemonMoves = pikachu.getPokemonMoves();
        String moveName = pokemonMoves.get(0).getMoves().getName();

        List<PokemonMoves> gravelerMoves = graveler.getPokemonMoves();
        String gravelerMoveName = pokemonMoves.get(0).getMoves().getName();


        modelMap.put("pikachuSprite", pokemonSprite);
        modelMap.put("name", pikachu.getName());
        modelMap.put("move", moveName);

        modelMap.put("gravelerName", graveler.getName());
        modelMap.put("gravelerSprite", graveler.getPokemonSprite());
        modelMap.put("gravelerMove", gravelerMoveName);

        return "home";
    }

    private GameState gameState;

    public void gameStart() {
        gameState = GameState.Start;

        switch (gameState) {
            case Start:
                break;
            case QuizRoomOne:
                break;
            case ChryslerBossRoom:
                break;
            case QuizRoomTwo:
                break;
            case GMBossRoom:
                break;
            case Ford:
                break;
        }
    }

    public void startAtBeginning() {

    }

    public void startAtQuizRoomOne() {

    }

    public void startAtQuizRoomTwo() {

    }

    public void startAtGMBossRoom() {

    }

    public void startAtChryslerBossRoom() {

    }

}
