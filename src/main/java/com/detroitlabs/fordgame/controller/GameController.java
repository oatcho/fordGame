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

    // TODO: 2019-03-26 create instance of pokemon here. Also creat instance of timer here. make test for question method

    //Pokemon pokemon;
    //PokemonSprite pokemonSprite;
    //int randomQuestion = quizRepository.generateRandomNumberForTfQuestion();
    QuizRepository quizRepository = new QuizRepository();

    public int questionIndex = quizRepository.generateRandomNumberForTfQuestion();

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
    public String displayFirstQuizPage(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        setNewTfQuestion(modelMap);
        return "quiz1";
    }

    @RequestMapping("userAnswer")
    public ModelAndView quizLogic(@RequestParam("answer") String userAnswer, @RequestParam("banana") String tfAnswer,ModelMap modelMap){
        String quizResult = quizRepository.checkTrueFalseAnswer(userAnswer, tfAnswer);
        if (quizResult.equalsIgnoreCase("correct!")){
            String correctAnswer = "Johnny's satisfied with your competence and allows you to get on your way.";
            modelMap.put("tfQuestion", correctAnswer);
        }else {
            setNewTfQuestion(modelMap);
        }
        ModelAndView mv = new ModelAndView("quiz1");
        setPlayerPokemonDetails(modelMap);
        mv.addObject("result", quizResult);

        return mv;
    }

    @RequestMapping("/quizTwo")
    public String displaySecondQuizPage(ModelMap modelMap){
        setPlayerPokemonDetails(modelMap);
        setNewMcQuestion(modelMap);
        return "quiz2";
    }

    @RequestMapping("mcUserAnswer")
    public ModelAndView quiz2Logic(@RequestParam("answer") String userAnswer, @RequestParam("banana") String mcAnswer,ModelMap modelMap){
        String quizResult = quizRepository.checkMultipleChoiceAnswer(userAnswer, mcAnswer);
        if (quizResult.equalsIgnoreCase("correct!")){
            String correctAnswer = "The homeless woman is satisfied, she tells you about a route through an alley that you can take to avoid traffic. You save 5 minutes on your drive!";
            modelMap.put("mcQuestion", correctAnswer);
        }else {
            setNewMcQuestion(modelMap);
        }
        ModelAndView mv = new ModelAndView("quiz2");
        setPlayerPokemonDetails(modelMap);
        mv.addObject("result", quizResult);

        return mv;
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

    private void setNewTfQuestion(ModelMap modelMap){
        Question randomGenQuestion= quizRepository.ALL_TRUE_FALSE_QUESTIONS.get(quizRepository.generateRandomNumberForTfQuestion());
        String question = randomGenQuestion.getQuestion();
//       String question = quizRepository.ALL_TRUE_FALSE_QUESTIONS.get(quizRepository.generateRandomNumberForTfQuestion()).getQuestion();
        String questionAnswer = randomGenQuestion.getAnswer();
        modelMap.put("tfQuestion", question);
        modelMap.put("tfAnswer", questionAnswer);
    }

    private void setNewMcQuestion(ModelMap modelMap){
        Question randomGenQuestion= quizRepository.ALL_MC_QUETIONS.get(quizRepository.generateRandomNumberforMcQuestion());
        String question = randomGenQuestion.getQuestion();
        String questionAnswer = randomGenQuestion.getAnswer();
        modelMap.put("mcQuestion", question);
        modelMap.put("mcAnswer", questionAnswer);
    }

}
