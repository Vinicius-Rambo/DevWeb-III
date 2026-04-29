
package com.example.persistencia;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.persistencia.Models.Curso;
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

	@Test
	public void deveObterUmProfessorPeloID(){
		professorRepository repository = new professorRepository();
		
		Professor professores = repository.findProfessorById(5);

		System.out.println(professores);
	}

	@Test
	public void deveInserirUmProfessor(){
		professorRepository repository = new professorRepository();

		Curso curso = new Curso();
		curso.setCurso_id(1);

		Professor professor = new Professor();

		professor.setNome("Marcos granada");
		professor.setEmail("NovaTrilha@Ordem");
		professor.setDataNascimento(LocalDate.of(1980,11,30));
		professor.setSalarioBase(500.00);

		professor.setCurso(curso);

		professor = repository.inserir(professor);

		System.out.println(professor);
	}


}


