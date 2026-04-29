package com.example.persistencia.exceptions;

public class BancoDeDadosException extends RuntimeException{
    public BancoDeDadosException(String mensagem){
        super(mensagem);
    }
}
