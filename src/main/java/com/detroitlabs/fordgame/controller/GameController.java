package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.model.Pikachu;
import com.detroitlabs.fordgame.model.PikachuMoves;
import com.detroitlabs.fordgame.model.PikachuSprite;
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
        Pikachu pikachu = pokemonservice.fetchPikachu();

        PikachuSprite pikachuSprite = pikachu.getPikachuSprite();
        List<PikachuMoves> pikachuMoves = pikachu.getPikachuMoves();
        String moveName = pikachuMoves.get(0).getMoves().getName();


        modelMap.put("pikachuSprite", pikachuSprite);
        modelMap.put("name", pikachu.getName());
        modelMap.put("move", moveName);

        return "home";
    }
}
