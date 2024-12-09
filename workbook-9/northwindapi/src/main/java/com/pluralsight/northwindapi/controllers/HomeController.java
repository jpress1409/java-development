package com.pluralsight.northwindapi.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path = "/calculator", method = RequestMethod.GET)
    public String index(@RequestParam int num1, @RequestParam int num2){
        return "Hello Potato";
    }
}
