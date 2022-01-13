package br.com.lucio.greeting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.greeting.config.GreetingConfiguration;
import br.com.lucio.greeting.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingConfiguration configuration;

    @GetMapping
    public Greeting greeting(@RequestParam(defaultValue = "") String name){
        if(name.isEmpty()) {
            return Greeting.builder().id(1L).content(configuration.getDefaultValue()).build();
        }
        return Greeting.builder().id(1L).content(name).build();
    }

}
