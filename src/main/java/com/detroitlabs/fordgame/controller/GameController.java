package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.model.Pokemon;
import com.detroitlabs.fordgame.model.PokemonMoves;
import com.detroitlabs.fordgame.model.PokemonSprite;
import com.detroitlabs.fordgame.service.Pokemonservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {

    PokemonSprite pokemonSprite;

    @Autowired
    Pokemonservice pokemonservice;


    @RequestMapping("/")
    public String displayPokemon(ModelMap modelMap) {
        Pokemon pikachu = pokemonservice.fetchSinglePokemon(25);
//        Pokemon graveler

        Pokemon graveler = pokemonservice.fetchSinglePokemon(75);

        pokemonSprite = pikachu.getPokemonSprite();
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




        return "boss-test-template";
    }

    @RequestMapping("userMoveChoice")
    public ModelAndView battleLogic(@RequestParam("moveChoice") String moveChoice, ModelMap modelMap){
        ModelAndView mv = new ModelAndView("boss-test-template");
        String battleResult = checkBattleStatus(moveChoice);
        mv.addObject("result", battleResult);

        modelMap.put("pikachuSprite", pokemonSprite);

    return mv;
    }

    public String checkBattleStatus(String moveChoice){
        String move1 = "This move is not effective";
        String move3 = "Super effective, you defeated the boss";

        if (moveChoice.equals("y")) {
            return move3;
        } else if (moveChoice.equals("x")) {
            return move1;
        }
        return "";
    }

}


