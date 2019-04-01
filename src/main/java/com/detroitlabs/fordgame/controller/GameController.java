package com.detroitlabs.fordgame.controller;

import com.detroitlabs.fordgame.data.QuizRepository;
import com.detroitlabs.fordgame.model.*;
import com.detroitlabs.fordgame.service.Pokemonservice;
import com.detroitlabs.fordgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class GameController {

    private QuizRepository quizRepository = new QuizRepository();
    private Time timer = new Time();

    @Autowired
    Pokemonservice pokemonservice;

    @Autowired
    UserService userService;

    // **** User Auth **** //
    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView();
        if (error != null) {
            modelAndView.setViewName("error-page");
        } else modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");
        }
        return modelAndView;
    }
    // **** **** //

    // **** Start Page **** //
    @RequestMapping("/")
    public String displayStartPage(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelMap.put("user", user);
        return "start";
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
    // **** **** //

    // **** Quiz One **** //
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
            timer.addTimeForCorrectQuizAnswer();
            modelMap.put("tfQuestion", correctAnswer);
        }else {
            setNewTfQuestion(modelMap);
            timer.subtractTimeForQuiz();
        }
        String nextPage = showNextButtonOnQuizPages(quizResult);
        ModelAndView mv = new ModelAndView("quiz1");
        setPlayerPokemonDetails(modelMap);
        mv.addObject("result", quizResult);
        mv.addObject("next", nextPage);
        return mv;
    }

    private void setNewTfQuestion(ModelMap modelMap){
        Question randomGenQuestion= QuizRepository.ALL_TRUE_FALSE_QUESTIONS.get(quizRepository.generateRandomNumberForTfQuestion());
        String question = randomGenQuestion.getQuestion();
        String questionAnswer = randomGenQuestion.getAnswer();
        modelMap.put("tfQuestion", question);
        modelMap.put("tfAnswer", questionAnswer);
    }
    // **** **** //

    // **** Boss One **** //
    @RequestMapping("/bossOne")
    public String displayBossBattle1(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        setBossPokemonDetails(modelMap);
        return "boss";
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
    // **** **** //

    // **** Quiz Two **** //
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
            timer.addTimeForCorrectQuizAnswer();
            modelMap.put("mcQuestion", correctAnswer);
        }else {
            timer.subtractTimeForQuiz();
            setNewMcQuestion(modelMap);
        }
        String nextPage = showNextButtonOnQuizPages(quizResult);
        ModelAndView mv = new ModelAndView("quiz2");
        setPlayerPokemonDetails(modelMap);
        mv.addObject("result", quizResult);
        mv.addObject("next", nextPage);
        return mv;
    }

    private void setNewMcQuestion(ModelMap modelMap){
        Question randomGenQuestion= QuizRepository.ALL_MC_QUETIONS.get(quizRepository.generateRandomNumberforMcQuestion());
        String question = randomGenQuestion.getQuestion();
        String questionAnswer = randomGenQuestion.getAnswer();
        modelMap.put("mcQuestion", question);
        modelMap.put("mcAnswer", questionAnswer);
    }
    // **** **** //

    // **** Boss Two **** //
    @RequestMapping("/bossTwo")
    public String displayBossBattle2(ModelMap modelMap) {
        setPlayerPokemonDetails(modelMap);
        setBoss2PokemonDetails(modelMap);
        return "boss2";
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
    // **** **** //

    // **** Battle Logic **** //
    private String checkBattleStatus(String moveChoice){
        String move1 = "This move is not effective";
        String move3 = "Super effective, you defeated the boss";

        if (moveChoice.equals("y")) {
            timer.addTimeForBeatingBoss();
            return move3;
        } else if (moveChoice.equals("x")) {
            timer.subtractTimeForBossBattle();
            return move1;
        }
        return "";
    }
    // **** **** //

    // **** Conditional Button Render **** //
    private String showNextButtonOnQuizPages(String result) {
        String nextButton = "";
        String nextButtonCorrect = "Next Level";
        if (result.equalsIgnoreCase("correct!")) {
            timer.subtractTimeForAction();
            return nextButtonCorrect;
        } else {
            timer.subtractTimeForAction();
            return nextButton;
        }
    }

    private String showNextButton(String moveChoice) {
        String nextButton = "";
        String nextButtonCorrect = "Next Level";
        if (moveChoice.equals("x")) {
            timer.subtractTimeForAction();
            return nextButton;
        } else if (moveChoice.equals("y")) {
            timer.subtractTimeForAction();
            return nextButtonCorrect;
        }
        return "";
    }
    // **** **** //

}