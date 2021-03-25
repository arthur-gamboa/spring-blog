package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showRoll() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String diceRoll(@PathVariable int guess, Model model) {
        int randomNum = (int) Math.floor(Math.random() * 5) + 1;

        String result;

        if (guess == (randomNum)) {
            result = "Correct!";
        } else {
            result = "Incorrect.";
        }

        model.addAttribute("randomNum", randomNum);
        model.addAttribute("guess", guess);
        model.addAttribute("result", result);

        return "die-result";

    }
}
