package com.example.todolist.models;

import java.util.UUID;


import com.example.todolist.enums.EstadoTarefa;
import java.time.LocalDate;

public class Tarefa {
    
   private UUID id;
   private String tarefa;
   private EstadoTarefa estado; //Em vez de string pega os objetos do EstadoTarefa.java
   private LocalDate dataLimite;

    public Tarefa(String tarefa, LocalDate dataLimite){ //Contrutor da tarefa
        this.id = UUID.randomUUID(); //Gera um id aleatorio
        this.tarefa = tarefa;
        this.estado = EstadoTarefa.EM_ANDAMENTO; //Automaticamente toda tarefa está EM_ANDAMENTO
        this.dataLimite = dataLimite;
    }

   public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
   
    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
    public EstadoTarefa getEstado() {
        return estado;
    }

    public void setEstado(EstadoTarefa estado) {
        this.estado = estado;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    @Override
    public String toString() { //Sempre que tentar chamar um objeto como string. 
        return this.getTarefa(); //Retorna a tarefa
        
    }

}
