package com.example.persistencia_jpa.entidades;

import java.io.Serializable;
import java.util.List;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.persistencia_jpa.enumeracoes.StatusLivro;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tb_livros") //Opcional, se não houver vai criar a tabela com o mesmo nome.
@Data //Gera automaticamente os Getters e Setters.
public class Livro implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id incremental
    private Long id;

    @Column(name = "titulo", nullable = false, length=240)
    private String titulo;

    @NotEmpty
    private String autor;
    
    @Size(min = 10, max=13)
    @Column(unique = true)

    private String isbn;
    private boolean disponivel = true;
    
    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    @ElementCollection
    private List<String> palavrasChave;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @UpdateTimestamp
    private LocalDateTime ultimaAtualizacao;

    private Integer quantidadeDisponivel;

    @Version
    private Long versao;
}
