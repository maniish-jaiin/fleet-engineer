package com.coup.fleet_engineers.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Coup!";
    }
}
