package br.edu.ifpr.foz.pizzatopping.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping({"","/"})
public class PizzaController {

    private ArrayList<String> listaPizzas = new ArrayList<>();

    public PizzaController(){ //Construtor
        listaPizzas.add("catupiry");
        listaPizzas.add("calabreza");
        listaPizzas.add("portuguesa");
    }

    @GetMapping("/pizzas")
    @ResponseBody
    public String pizzas(){

        return listaPizzas.toString();
    }

    @GetMapping("/pizzas/{tipo}")
    @ResponseBody
    public String pizzasTipo(@PathVariable(value = "tipo") String tipo, @RequestParam(required = false) String precoMax){

    //     if(tipo.equals("vegetariana")){

    //         return "Não temos essa opção";
        
    //     } else if (tipo.equals("especiais")){

    //         return listaPizzas.get(0);
    //     }


    //     return listaPizzas.toString();
        if(precoMax == null){
            return "O preco maximo não foi informado.";
        }    

        return "O preco máximo foi: " + precoMax;
    }

    @PostMapping("/cadastrar")
    @ResponseBody
    public String cadastrarPizza(@RequestParam String pizza ) {
        
        this.listaPizzas.add(pizza);
        
        return "pizza cadastrada";
    }
    
        
}
