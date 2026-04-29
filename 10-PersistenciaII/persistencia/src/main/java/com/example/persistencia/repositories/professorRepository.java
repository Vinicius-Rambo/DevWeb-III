package com.example.persistencia.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.persistencia.Models.Curso;
import com.example.persistencia.Models.Professor;
import com.example.persistencia.exceptions.BancoDeDadosException;
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
            resultado = consulta.executeQuery("SELECT p.*, c.nome AS curso_nome FROM professores AS p JOIN cursos as c ON p.curso_id = c.curso_id;");

            Map<Integer, Curso> cursosMap = new HashMap<>();



            while (resultado.next()) {

                Curso curso  = cursosMap.get(resultado.getInt("curso_id"));

                if(curso == null) {
                    curso = new Curso();
                    curso.setNome(null);
                    curso.setCurso_id(resultado.getInt("curso_id"));

                    cursosMap.put(resultado.getInt("curso_id"), curso);
                }

                Professor professor = resultadoToProfessor(resultado, curso);
                professores.add(professor);
            }

            return professores;

        } catch(SQLException e){
            throw new RuntimeException(e);

        } finally{
            ConexaoFactory.fecharResultSet(resultado);
            ConexaoFactory.fecharStatement(consulta);

        }
    }
    public Professor findProfessorById(Integer id){
        PreparedStatement consulta = null; 
        ResultSet resultado = null;
        Professor professor = null;

        try{

            String sql = "SELECT p.*, c.nome AS curso_nome FROM professores AS p JOIN cursos as c ON p.curso_id = c.curso_id Where professor_id = ? ;";
            consulta = conexao.prepareStatement(sql);

            consulta.setInt(1,id);

            resultado = consulta.executeQuery();


            while (resultado.next()) {

                Curso curso = new Curso();
                curso.setCurso_id(resultado.getInt("curso_id"));
                curso.setNome(resultado.getString("curso_nome"));
                
                professor = resultadoToProfessor(resultado, curso);
                
            }


        } catch(SQLException e){
            throw new RuntimeException(e);

        } finally{
            ConexaoFactory.fecharResultSet(resultado);
            ConexaoFactory.fecharStatement(consulta);

        }

        return professor;
    }

    public Professor inserir (Professor professor){

        PreparedStatement consulta = null;
        
        try{
            String sql = "Insert INTO professores(nome, email, data_nascimento, salario_base, curso_id)" + "Values(?,?,?,?,?)";
            consulta = conexao.prepareStatement(sql);

            consulta.setString(1, professor.getNome());
            consulta.setString(2, professor.getEmail());
            consulta.setDate(3, Date.valueOf(professor.getDataNascimento()));
            consulta.setDouble(4, professor.getSalarioBase());
            consulta.setDouble(5, professor.getCurso().getCurso_id());

            int linhasAfetadas = consulta.executeUpdate();

            if(linhasAfetadas > 0 ){
                System.out.println("Pronto! " + linhasAfetadas + "linhas afetadas.");
                ResultSet ids = consulta.getGeneratedKeys();

                ids.next();

                int id = ids.getInt(1);
                professor.setId(id);
            }else
                System.out.println("Nenhum registro");

        }catch(SQLException e){
            throw new RuntimeException("Erro ao inserir");

        }finally{
            ConexaoFactory.fecharStatement(consulta);
        }
        return professor;

    }





    public Professor resultadoToProfessor(ResultSet resultado, Curso curso) throws SQLException{
        Professor p = new Professor();

        p.setId(resultado.getInt("Professor_id"));
        p.setNome(resultado.getString("nome"));
        p.setEmail(resultado.getString("email"));
        p.setDataNascimento(resultado.getDate("data_nascimento").toLocalDate());
        p.setSalarioBase(resultado.getDouble("salario_base"));
        
        p.setCurso(curso);

        
        return p;
    }
}
