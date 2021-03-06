/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.util.Conexao;

import model.database.entities.Ferramenta;

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
    
    public ArrayList<Ferramenta> selectAllFerramentasFromProfessor(int id) {
        ArrayList<Ferramenta> ferramProfList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM professor_ferramenta"
                    + " WHERE fk_id_usuario = " + id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                Ferramenta ferramenta = new Ferramenta();
                ferramenta.setId_usuario(id);
                ferramenta.setNome_ferramenta(data.getString("nome_ferramenta"));                
                                
                ferramProfList.add(ferramenta);
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE FERRAMENTAS DOS PROFESSORES");
         }
                                         
        return ferramProfList;
    }
}
