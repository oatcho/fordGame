package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.data.QuizRepository;
import com.detroitlabs.fordgame.model.Pokemon;
import com.detroitlabs.fordgame.model.PokemonMoves;
import com.detroitlabs.fordgame.model.PokemonSprite;
import com.detroitlabs.fordgame.model.Question;
import com.detroitlabs.fordgame.service.Pokemonservice;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {

    Pokemon pokemon;
    PokemonSprite pokemonSprite;

    @Autowired
    Pokemonservice pokemonservice;

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

    @RequestMapping("/quizTwo")
    public String displaySecondQuizPage(ModelMap modelMap, QuizRepository quizRepository){
        setPlayerPokemonDetails(modelMap);
        String question = QuizRepository.ALL_MC_QUETIONS.get(quizRepository.generateRandomNumberforMcQuestion()).getQuestion();
        modelMap.put("mcQuestion", question);
        return "quiz2";
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

    private void setBossPokemonDetails(ModelMap modelMap) {
        Pokemon graveler = pokemonservice.fetchSinglePokemon(75);
        PokemonSprite pokemonSprite = graveler.getPokemonSprite();
        modelMap.put("gravelerSprite", pokemonSprite);
        modelMap.put("gravelerName", graveler.getName());
        modelMap.put("gravelerMove", graveler.getPokemonMoves());
        modelMap.put("gravelerWeight", graveler.getWeight());
        modelMap.put("gravelerBaseExperience", graveler.getBase_experience());
        modelMap.put("gravelerId", graveler.getId());
    }

    private void setBoss2PokemonDetails(ModelMap modelMap) {
        Pokemon deoxys = pokemonservice.fetchSinglePokemon(386);
        PokemonSprite pokemonSprite = deoxys.getPokemonSprite();
        modelMap.put("deoxysSprite", pokemonSprite);
        modelMap.put("deoxysName", deoxys.getName());
        modelMap.put("deoxysMove", deoxys.getPokemonMoves());
        modelMap.put("deoxysWeight", deoxys.getWeight());
        modelMap.put("deoxysBaseExperience", deoxys.getBase_experience());
        modelMap.put("deoxysId", deoxys.getId());
    }


    @RequestMapping("/bossOne")
    public String displayBossBattle1(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        setBossPokemonDetails(modelMap);
        return "boss";
    }

    @RequestMapping("/bossTwo")
    public String displayBossBattle2(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        setBoss2PokemonDetails(modelMap);
        return "boss2";
    }



    @RequestMapping("userMoveChoice")
    public ModelAndView battleLogic(@RequestParam("moveChoice") String moveChoice, ModelMap modelMap){
        ModelAndView mv = new ModelAndView("boss");
        String battleResult = checkBattleStatus(moveChoice);
        String nextPage = showNextButton(moveChoice);
        mv.addObject("result", battleResult);
        mv.addObject("next", nextPage);

        setPlayerPokemonDetails(modelMap);
        setBossPokemonDetails(modelMap);

        return mv;
    }

    @RequestMapping("userMoveChoice2")
    public ModelAndView battleLogic2(@RequestParam("moveChoice2") String moveChoice2, ModelMap modelMap){
        ModelAndView mv = new ModelAndView("boss2");
        String battleResult = checkBattleStatus(moveChoice2);
        String nextPage = showNextButton(moveChoice2);
        mv.addObject("result2", battleResult);
        mv.addObject("next", nextPage);

        setPlayerPokemonDetails(modelMap);
        setBoss2PokemonDetails(modelMap);

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

    public String showNextButton(String moveChoice) {
        String nextButton = "";
        String nextButtonCorrect = "←Next Level";
        if (moveChoice.equals("x")) {
            return nextButton;
        } else if (moveChoice.equals("y")) {
            return nextButtonCorrect;
        }
        return "";
    }

}


