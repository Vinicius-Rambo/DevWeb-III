package com.example.todolist.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todolist.enums.EstadoTarefa;
import com.example.todolist.models.Tarefa;

@Controller
public class GerenciadorTarefasController {

    public GerenciadorTarefasController(){ //Construtor top
        Tarefa t1 = new Tarefa("Ler um bom livro", LocalDate.now());
        listaTarefas.add(t1);

        Tarefa t2 = new Tarefa("Levar o cachorro para passear", LocalDate.now());
        listaTarefas.add(t2);

        Tarefa t3 = new Tarefa("Marcar dentista", LocalDate.now());
        listaTarefas.add(t3);
    }

    private List<Tarefa> listaTarefas = new ArrayList<>();

    @GetMapping({"", "/", "/tarefas"})
    public String todos(Model model){

        model.addAttribute("listaTarefas", listaTarefas);

        return "todo_list";

    }

    //@PostMapping("/add")
    /*  public String add (@RequestParam String tarefa, @RequestParam LocalDate dataLimite){ 
                
        Tarefa tarefa = new tarefa(); //Metodo inosual, sem usar os poderes do Spring  

    }*/
    @PostMapping("/add")
    public String add(Tarefa tarefa){

        this.listaTarefas.add(tarefa);

        return "redirect:/tarefas"; //Após adicionar redireciona novamente ao Get.
    
    }

    @GetMapping("/apagar/{id}")
    public String removerTarefa(@PathVariable UUID id){

        for(Tarefa tarefa : listaTarefas){

           if(tarefa.getId().equals(id)){
                listaTarefas.remove(tarefa);
                break;
            }
            
        }
        
        return "redirect:/tarefas"; //Após adicionar redireciona novamente ao Get.
    }

    @GetMapping("/alterar_estado/{id}")
    public String alterarEstado(@PathVariable UUID id){

        for (Tarefa tarefa : listaTarefas){
            if(tarefa.getId().equals(id)){

                tarefa.setEstado(tarefa.getEstado().equals(EstadoTarefa.EM_ANDAMENTO) ? EstadoTarefa.FEITO : EstadoTarefa.EM_ANDAMENTO);
                break;
            }
        }
        return "redirect:/tarefas";
    }

    @GetMapping("/editar/")
    public String editar(@PathVariable UUID id, Model model){

        for (Tarefa tarefa : listaTarefas) {
            if(tarefa.getId().equals(id)){

                model.addAttribute("tarefa", novaTarefa);
                return "tarefa_editar";

            }
        }
        return "redirect:/tarefas";


       
    }

}
