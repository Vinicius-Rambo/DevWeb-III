package com.example.persistencia_jpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.assertj.core.api.Assertions;

import com.example.persistencia_jpa.entidades.Livro;
import com.example.persistencia_jpa.enumeracoes.StatusLivro;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@SpringBootTest
class PersistenciaJpaApplicationTests {

	@Autowired
	private EntityManager entityManager; // Faz uma conexão com o banco já protegido

	@Test
	@Transactional
	@Rollback(false)
	public void deveInserirUmLivro() {
		Livro l1 = new Livro();
		l1.setTitulo("Clean code");
		l1.setAutor("Robert C. Martin");
		l1.setIsbn("123");
		l1.setDisponivel(true);
		l1.setStatus(StatusLivro.EM_BOM_ESTADO);
		l1.setPalavrasChave(Arrays.asList("Bom", "tecnico", "informatica"));

		entityManager.persist(l1);

		System.out.println("O id do objeto inserido foi: " + l1.getId());

		entityManager.flush();

		// Asse45rtion.assertThat(l1.getId().isNotNull());

	}

	@Test
	public void deveBuscarUmLivroPeloSeuID() {

		Livro l1 = entityManager.find(Livro.class, 3);

		// System.out.println(l1);

		Assertions.assertThat(l1).isNotNull();
		Assertions.assertThat(l1.getTitulo()).isEqualTo("Clean code");

		l1.setTitulo("Outro titulo de livro");

		entityManager.flush();
	}

	@Test
	public void deveRemoverUmLivro() {
		Livro l1 = new Livro();
		l1.setId(3l);

		entityManager.remove(1);
	}

	@Test
	@Transactional
	@Rollback(false)
	void deveExcluirLivro() {
		// Suponha que exista um livro com ID 1
		Livro livro = entityManager.find(Livro.class, 1L);
		assertNotNull(livro, "Livro não encontrado para exclusão");
		entityManager.remove(livro);
		Livro apagado = entityManager.find(Livro.class, 1L);
		assertNull(apagado);
		System.out.println("Livro excluído com sucesso.");
	}

	@Test
	void contextLoads() {
	}

}
