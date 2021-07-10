package com.prolimner.springbootjune.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // @RequestMapping(method = RequestMethod.GET, value = "/")
    @GetMapping("/")
    public String helloWorld() {

        return "yeah!! live reload baby";
    }
}
