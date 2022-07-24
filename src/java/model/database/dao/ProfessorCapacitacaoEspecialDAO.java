/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.util.Conexao;

import model.database.entities.CapacitacaoEspecial;

/**
 *
 * @author lieds
 */
public class ProfessorCapacitacaoEspecialDAO {
    
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public ProfessorCapacitacaoEspecialDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO professorDisciplinaDAO " + ex);
        }
    }
    
    public ArrayList<CapacitacaoEspecial> selectAllCapacitacaoFromProfessor(int id) {
        ArrayList<CapacitacaoEspecial> capacitProfList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM professor_capacitacao_especial"
                    + " WHERE fk_id_usuario = " + id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                CapacitacaoEspecial capacitacao = new CapacitacaoEspecial();                
                capacitacao.setId_usuario(id);
                capacitacao.setNome_capacitEspecial(data.getString("nome_capacitacao_especial"));
                capacitacao.setId_condicaoEspecial(data.getInt("fk_id_condicao_especial"));
                capacitProfList.add(capacitacao);
                
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE FERRAMENTAS DOS PROFESSORES");
         }
                                         
        return capacitProfList;
    }
}
