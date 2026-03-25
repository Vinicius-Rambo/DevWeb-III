package com.example.todolist.enums;

public enum EstadoTarefa {

    EM_ANDAMENTO ("Em andamento"), //Texto do EM_andamento
    FEITO ("Feito"); 

    private String descricao;

    EstadoTarefa(String descricao){ //Construtor para poder funciona o texto
        this.descricao = descricao; //Define a descrição da clase para descricao.
    }

    public String getDescricao(){ //Pegar a descricao
        return this.descricao;
    }

}
