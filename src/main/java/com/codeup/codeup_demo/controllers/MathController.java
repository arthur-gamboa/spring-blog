package com.codeup.codeup_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{numOne}/and/{numTwo}")
    @ResponseBody
    public int add(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne + numTwo;
    }

    @GetMapping("/subtract/{numOne}/and/{numTwo}")
    @ResponseBody
    public int subtract(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne - numTwo;
    }

    @GetMapping("/multiply/{numOne}/and/{numTwo}")
    @ResponseBody
    public int multiply(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne * numTwo;
    }

    @GetMapping("/divide/{numOne}/and/{numTwo}")
    @ResponseBody
    public int divide(@PathVariable int numOne, @PathVariable int numTwo) {
        return numOne / numTwo;
    }

}
