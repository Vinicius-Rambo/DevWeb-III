package br.edu.ifpr.foz.pizzatopping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
@RequestMapping("/atv1")
public class ProdutoController {

    @GetMapping("/produtos")
    @ResponseBody
    public String ProdutosListar(){
        return "Listar todos os produtos";
    }

    @GetMapping("/produtos/{tipo}")
    @ResponseBody
    public String ProdutoEspecifico(@PathVariable(value = "tipo") String tipo) {
        return "O produto: " + tipo + "foi selecionado";
    }

    @PostMapping("/produtos")
    @ResponseBody
    public String ProdutosPost(@RequestParam String produtos ) {
   
        return "Um novo produto com os dados: " + produtos + " foi cadastrado";
    }

    @PutMapping("produtos/{id}")
    @ResponseBody
    public String ProdutosPut(@RequestParam String id){
        
        return "Um produto o " + id + "foi atualizado"; 
    }

    @DeleteMapping("produtos/{id}")
    @RequestBody
    public String ProdutosDelete(@RequestParam String )


    

    

    



}
