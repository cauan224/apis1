package com.example.aula20.contrller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wel")
public class Welcom {
    @GetMapping
    public String welcom(){
        return "bem vindo ";
    }
}
