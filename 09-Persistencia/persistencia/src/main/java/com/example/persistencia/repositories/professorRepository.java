package com.example.persistencia.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.persistencia.Models.Professor;
import com.example.persistencia.infrastructure.ConexaoFactory;


public class professorRepository {
    
    private Connection conexao;

    public professorRepository(){
        conexao = ConexaoFactory.getConexao();
    }

    public List<Professor> getProfessores(){
        List<Professor> professores = new ArrayList<>();
        Statement consulta = null; 
        ResultSet resultado = null;

        try{
            consulta = conexao.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM professores");

        
            while (resultado.next()) {
                Professor p = new Professor();

                p.setId(resultado.getInt("Professor_id"));
                p.setNome(resultado.getString("nome"));
                p.setEmail(resultado.getString("email"));
                p.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
                p.setSalarioBase(resultado.getDouble("salario_base"));
              
                professores.add(p);
            }

            return professores;

        } catch(SQLException e){
            throw new RuntimeException(e);

        }
    }

    public Professor resultadoToProfessor(ResultSet resultado) throws SQLException{
        Professor p = new Professor();

        p.setId(resultado.getInt("Professor_id"));
        p.setNome(resultado.getString("nome"));
        p.setEmail(resultado.getString("email"));
        p.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
        p.setSalarioBase(resultado.getDouble("salario_base"));
        
        return p;
    }

}
