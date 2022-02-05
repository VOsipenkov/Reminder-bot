package org.bot.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final ApplicationContext applicationContext;

    @Autowired
    public GreetingController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @GetMapping(value = "/greeting")
    public String greeting() {
        return "greeting";
    }
}
