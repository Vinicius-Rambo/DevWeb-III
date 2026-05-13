package com.example.persistencia_lab.models;

import java.time.LocalDate;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Professor {

    private Integer id;
    private String nome;
    private String email;
    private String senha; //Adicionando recentemente paizão

    private Double salarioBase;
    private Curso curso = null;
    private LocalDate dataNascimento;

    public Professor() {
    }

    public Professor(Integer id, String nome, String email, String senha, LocalDate dataNascimento, Double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.salarioBase = salarioBase;

        this.senha = this.setSenha(senha);
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
                + ", salarioBase=" + salarioBase + ", curso=" + curso + "]";
    }

    public String setSenha(String senha){
        PasswordEncoder encoder = new BCryptPasswordEncoder(); //Interface de criptografia
        return encoder.encode(senha); //Transforma a senha em criptografada
    }

    public String setSenhaHashed(String senhaHashed){
        this.senha = senhaHashed;

        return this.senha;
    }

    public String getSenha(){
        return this.senha;
    }
}
