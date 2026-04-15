package com.example.persistencia;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.persistencia.Models.Professor;
import com.example.persistencia.infrastructure.ConexaoFactory;
import com.example.persistencia.repositories.professorRepository;

@SpringBootTest
class PersistenciaApplicationTests {

	@Test
	void databaseTest(){
		ConexaoFactory.getConexao();
	}

	@Test
	public void deveObterUmalistadeProfessores(){
		professorRepository repository = new professorRepository();
		
		List<Professor> professores = repository.getProfessores();

		for(Professor p : professores){
			System.out.println(p.toString());
		}
	}
}


