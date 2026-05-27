package com.example.persistencia_jpa.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.persistencia_jpa.entidades.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
    public void buscarLivroPeloNome();
}
