package com.atv.lista1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping({"", "/", "/exercicio1"})
public class helloWorld {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "Olá mundo";
    }



 



}
