/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.SQLException;
import model.util.Conexao;

/**
 *
 * Faz o CRUD com a tabela "professor_ferramenta" no banco de dados
 * 
 * @author lieds
 */
public class ProfessorFerramentaDAO {
    
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public ProfessorFerramentaDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO professorDisciplinaDAO " + ex);
        }
    }
}
