/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.util.Conexao;
import model.database.entities.Aluno;
import model.database.entities.Professor;

/**
 *
 * @author lieds
 */
public class UsuarioDAO {
    
    private Conexao conn;
    
    public UsuarioDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO UsuarioDAO " + ex);
        }
    }
    
    //USUÁRIO PROFESSOR
    
    /*public ArrayList<Professor> selectAllProfessores() {
        ArrayList<Professor> professorList = new ArrayList<>();
        
        try {                        
            
            String sql = "SELECT * FROM usuario WHERE tipo_usuario LIKE 'Professor'";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while(data.next()) { 
                Professor user = new Professor();
                user.setMatricula(data.getString("matricula"));
                user.setNome_completo(data.getString("nome_completo"));                
                user.setData_nascimento(data.getDate("data_nascimento"));
                user.setTipo_usuario(data.getString("tipo_usuario"));
                user.setAutodescricao(data.getString("autodescricao"));
                professorList.add(user);                
            }                        
                                            
        } catch (SQLException ex) {
            System.out.println("ERRO AO PESQUISAR PROFESSORES!");
        } catch (ParseException ex) {
            System.out.println("ERRO AO PUXAR A DATA");;
        }
                
        return professorList;
        
    }*/
    
    public boolean insertProfessor(Professor user) {
        String sql;    
        Date dataDB_Format = new Date(user.getData_nascimento().getTime());
        
        try {                        
                                   
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario)"
                    +" VALUES ('" + user.getMatricula() + "', '" +
                    user.getNome_completo() + "', '" +
                    user.getSenha() + "', '" +
                    dataDB_Format + "', '" +
                    user.getTipo_usuario() + "')";                         
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    //USUÁRIO ALUNO
    
     public boolean insertAluno(Aluno user) {
        String sql;    
        Date dataDB_Format = new Date(user.getData_nascimento().getTime());
        
        try {                        
                                   
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario)"
                    +" VALUES ('" + user.getMatricula() + "', '" +
                    user.getNome_completo() + "', '" +
                    user.getSenha() + "', '" +
                    dataDB_Format + "', '" +
                    user.getTipo_usuario() + "')";                         
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    
    public int selectMaxID() {
        int maxID = 0;
        
        try {
            String sql = "SELECT MAX(id_usuario) as maxID FROM usuario";            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next();
            maxID = data.getInt("maxID");                                  
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");            
        }
        
        return maxID;
    }
  
}
