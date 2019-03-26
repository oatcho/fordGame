package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.data.QuizRepository;
import com.detroitlabs.fordgame.model.Pokemon;
import com.detroitlabs.fordgame.model.PokemonMoves;
import com.detroitlabs.fordgame.model.PokemonSprite;
import com.detroitlabs.fordgame.model.Question;
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

//    @RequestMapping("/")
//    public String displayPokemon(ModelMap modelMap) {
//        Pokemon pikachu = pokemonservice.fetchSinglePokemon(25);
////        Pokemon graveler
//
//        Pokemon graveler = pokemonservice.fetchSinglePokemon(75);
//
//        PokemonSprite pokemonSprite = pikachu.getPokemonSprite();
//        List<PokemonMoves> pokemonMoves = pikachu.getPokemonMoves();
//        String moveName = pokemonMoves.get(0).getMoves().getName();
//
//        List<PokemonMoves> gravelerMoves = graveler.getPokemonMoves();
//        String gravelerMoveName = pokemonMoves.get(0).getMoves().getName();
//
//
//        modelMap.put("pikachuSprite", pokemonSprite);
//        modelMap.put("pikachuName", pikachu.getName());
////        modelMap.put("move", moveName);
//        modelMap.put("pikachuMove", pikachu.getPokemonMoves());
//        modelMap.put("pikachuWeight", pikachu.getWeight());
//        modelMap.put("pikachuBaseExperience", pikachu.getBase_experience());
//        modelMap.put("pikachuId", pikachu.getId());
//
//        modelMap.put("gravelerName", graveler.getName());
//        modelMap.put("gravelerSprite", graveler.getPokemonSprite());
//        modelMap.put("gravelerMove", gravelerMoveName);
//
//        return "start";
//    }

    @RequestMapping("/")
    public String displayStartPage(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        return "start";
    }

    @RequestMapping("/quizOne")
    public String displayFirstQuizPage(ModelMap modelMap, QuizRepository quizRepository) {
       setPlayerPokemonDetails(modelMap);
       String question = QuizRepository.ALL_TRUE_FALSE_QUESTIONS.get(quizRepository.generateRandomNumberForTfQuestion()).getQuestion();
       modelMap.put("tfQuestion", question);
        return "quiz1";
    }

    private void setPlayerPokemonDetails(ModelMap modelMap) {
        Pokemon pikachu = pokemonservice.fetchSinglePokemon(25);
        PokemonSprite pokemonSprite = pikachu.getPokemonSprite();
        modelMap.put("pikachuSprite", pokemonSprite);
        modelMap.put("pikachuName", pikachu.getName());
        modelMap.put("pikachuMove", pikachu.getPokemonMoves());
        modelMap.put("pikachuWeight", pikachu.getWeight());
        modelMap.put("pikachuBaseExperience", pikachu.getBase_experience());
        modelMap.put("pikachuId", pikachu.getId());
    }
}
