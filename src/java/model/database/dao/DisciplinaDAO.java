/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.util.Conexao;
import model.database.entities.Disciplina;

/**
 * 
 * Faz o CRUD com a tabela "disciplina" no banco de dados
 *
 * @author lieds
 */
public class DisciplinaDAO {
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public DisciplinaDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO UsuarioDAO " + ex);
        }
    }
    
    /**
     * Retorna todas as disciplinas cadastradas no banco de dados
     * 
     * @return ArrayList - Retorna uma lista do tipo Disciplina
     */
    public ArrayList<Disciplina> selectAllDisciplinas() {
        ArrayList<Disciplina> disciplinasList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM disciplina";         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                Disciplina disciplina = new Disciplina();
                disciplina.setNome_disciplina(data.getString("nome_disciplina"));
                disciplinasList.add(disciplina);                
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE DISCIPLINAS");
         }
        return disciplinasList;
    }
    
    /**
     * Retorna as informações um objeto do tipo disciplina com
     * as informações desta, usando o código como forma de pesquisa
     * 
     * @param cod - código do disciplina
     * @return Disciplina - retorna a disciplina que contenha aquele código
     */
    public Disciplina selectDisciplinaByCodigo(int cod){
        Disciplina disciplina = new Disciplina();
        
        try {            
            String sql = "SELECT * FROM disciplina WHERE cod_disciplina = " + cod;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            data.next();
            
            disciplina.setCodigo_disciplina(cod);
            disciplina.setNome_disciplina(data.getString("nome_disciplina"));            
            
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE DISCIPLINAS");
         }
        
        return disciplina;
    }
            
}
