package com.example.estudantes.Controllers;
import com.example.estudantes.Models.Estudante;
import com.example.estudantes.Services.FileUploadService;

import jakarta.validation.Valid;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private FileUploadService fileUploadService; 

    @GetMapping("/cadastrar")
    public String cadastrar(Estudante estudante){

        return "estudantes-cadastrar.html";
    }

    @PostMapping("/salvar")
    @ResponseBody
    public String salvar(@Valid Estudante estudante, BindingResult results) throws IOException{

        if (results.hasErrors()){

            return "estudantes-cadastrar.html";
        }

        System.out.println("O nome informado foi: " + estudante.getNome());
        System.out.println(estudante.getDataIngresso());
        System.out.println(estudante.getAvatar().getOriginalFilename());
        
        for (String hab : estudante.getHabilidades()){
            System.out.println(hab);
        }

        String nomeArquivo = fileUploadService.upload(estudante.getAvatar());
        System.out.println("O novo nome do arquivo é: " + nomeArquivo);


        return "";
        // return "estudantes-sucesso";
    }   
}
