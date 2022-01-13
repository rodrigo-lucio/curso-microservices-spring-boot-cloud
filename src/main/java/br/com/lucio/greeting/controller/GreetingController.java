package br.com.lucio.greeting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucio.greeting.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Greeting greeting(@RequestParam(defaultValue = "test") String name){
        return Greeting.builder().id(1L).content(name).build();
    }

}
