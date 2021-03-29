package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
class HelloController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);

        List<String> names = new ArrayList<>();

        names.add("Sam");
        names.add("Dorian");
        names.add("Diego");

        model.addAttribute("aName", name.toUpperCase());
        model.addAttribute("admin", name.equals("fer"));
        model.addAttribute("nameList", names);

        return "hello";
    }


    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(
            @RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("welcomeMessage", "Welcome to " + cohort + "!");
        return "join";
    }

}