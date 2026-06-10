package com.example.ordem_servico_api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //Retorna um erro 404, em vez do 500.
public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String resource, Long id){
        super(String.format("%s com id %d não encontrada", resource, id));
    }
}
