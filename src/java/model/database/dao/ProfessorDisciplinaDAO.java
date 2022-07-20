/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.database.entities.Disciplina;
import model.database.entities.Professor;

import model.util.Conexao;

/**
 *
 * Faz o CRUD com a tabela "professor_disciplina" no banco de dados
 * 
 * @author lieds
 */
public class ProfessorDisciplinaDAO {
    
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public ProfessorDisciplinaDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO professorDisciplinaDAO " + ex);
        }
    }
    
    /**
     * Linka um professor com uma disciplina no banco de dados
     * 
     * @param prof - Objeto contendo o professor que será linkado
     * @param disc - Objeto contendo a disciplina escolhida
     * @return Boolean - Feedback com o resultado da operação
     */
    public boolean cadastrarProfessorDisciplina(Professor prof, Disciplina disc) {
        String sql;        
        
        try {            
                        
            sql = "INSERT INTO professor_disciplina (fk_id_usuario, fk_cod_disciplina)"
                    + " VALUES ( " + prof.getId_usuario() + ", " + disc.getCodigo_disciplina() + ")";
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    /**
     * Seleciona todas as disciplinas linkadas com um professor
     * 
     * @param id - id do professor
     * @return ArrayList - Lista contendo as disciplinas do professor no formato Disciplina
     */
    public ArrayList<Disciplina> selectAllDisciplinasFromProfessor(int id) {
        ArrayList<Disciplina> discProfList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM professor_disciplina WHERE fk_id_usuario = " + id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setCodigo_disciplina(data.getInt("fk_cod_disciplina"));
                //emailRegister.setEmail(data.getString("email"));                
                discProfList.add(disciplina);
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE DISCIPLINA DE PROFESSORES");
         }
                                         
        return discProfList;
    }
        
}
