package com.example.thymeleaf.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String todo (Model model){

        ArrayList<String> list = new ArrayList<>();

        list.add("Fazer arroz");
        list.add("Fazer feijão");
        list.add("Fazer carne");
        
        model.addAttribute("lista", list);

        return "todo";
    }

    @GetMapping("/add")
    public String add(){

        System.out.println("Método add invocado");

        return "";
    }
   
}
