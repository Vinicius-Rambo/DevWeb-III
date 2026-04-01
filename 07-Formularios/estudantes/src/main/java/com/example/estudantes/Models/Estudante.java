package com.example.estudantes.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.*;

@Component
public class Estudante {

    @NotBlank(message = "O campo nome não pode ser vazio") 
    private String nome;
    
    @NotNull
    @PastOrPresent(message = "A data de ingresso não pode ser futura")
    private LocalDate dataIngresso; 
    
    @NotEmpty(message = "Selecione ao menos uma habilidade")
    private List<String> habilidades = new ArrayList<>();

    private MultipartFile avatar; //TIPO: arquivos do spring .

    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Data Ingresso
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    //Habilidades
    public List<String> getHabilidades() {
        return habilidades;
    }
    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    //MultiPart File
    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
    


}
