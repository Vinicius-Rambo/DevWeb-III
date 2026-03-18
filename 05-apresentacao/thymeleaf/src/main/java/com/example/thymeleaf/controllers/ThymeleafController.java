package com.example.thymeleaf.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class ThymeleafController {
    
    @GetMapping
    public String home(Model model){
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Gabi");
        list.add("Carol");
        list.add("Leo");
        list.add("Breno");
        list.add("Vinicius");
        list.add("Gabriel");


        //Buscar os produtos no banco de dados

        //Gerar uma lista


        String turma = "TADS";
        Integer ano = 2026;

        model.addAttribute("turma", turma); // Envia para o home.html o valor "turma" vindo da variavel turma
        model.addAttribute("ano", ano);
        model.addAttribute("lista", list);

        return "home";
    }
}
