package br.com.lucio.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.greeting.configuration.GreetingConfiguration;
import br.com.lucio.greeting.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingConfiguration configuration;

    @GetMapping
    public Greeting greeting(@RequestParam(defaultValue = "") String name) {
        if (name.isEmpty()) name = configuration.getDefaultValue();
        return new Greeting(1l, name);
    }
}
