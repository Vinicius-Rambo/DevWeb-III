package com.example.persistencia.infrastructure;

import java.sql.Statement;
import java.sql.Connection; //Import com tudo por motivos de preguiça.
import java.sql.DriverManager; //Import com tudo por motivos de preguiça.
import java.sql.ResultSet;
import java.sql.SQLException; //Import com tudo por motivos de preguiça.

import com.example.persistencia.exceptions.BancoDeDadosException;

public class ConexaoFactory {

    private static Connection conexao = null; //constante
    
    public static Connection getConexao(){
        String database = "jdbc:mysql://localhost/ifpr_cursos"; //Qual banco de dados usar do Mysql.
        String usuario  = "root"; 
        String senha    = "bancodedados";

        //Padrão de projeto Singleton
        if (conexao == null){ //Garante a existencia de somente uma conexão
        
            try{
                return DriverManager.getConnection(database, usuario, senha); //Tentar fazer a conexão
            
            } catch(SQLException e){ //Tratamento de Exceção obrigatorio
                throw new BancoDeDadosException(e.getMessage()); //Joga a Exceção não checada

            }
        } 
        else {
            return conexao;
        }
    }  
    
    public static void fecharStatement(Statement consulta){ //Boa pratica para evitar lixo de memoria. 
         if(consulta != null){ //Sempre que a consulta for diferente de nula tenta fechar. 
                try{
                    consulta.close(); 
                }catch(SQLException e){
                    throw new BancoDeDadosException(e.getMessage());
                }
        }
    }

    public static void fecharResultSet(ResultSet resultado){
          if(resultado!= null){
                try{
                    resultado.close();

                }catch(SQLException e){
                    throw new BancoDeDadosException(e.getMessage());
                }
            }
    }
}
