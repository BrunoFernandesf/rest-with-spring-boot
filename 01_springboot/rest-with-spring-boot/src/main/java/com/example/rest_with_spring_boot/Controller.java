package com.example.rest_with_spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    private final HelloWorld helloWorld = new HelloWorld();


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greetings")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World")
                               String name){
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/hello")
    public String helloworld() {
        return helloWorld.hello();
    }

}
