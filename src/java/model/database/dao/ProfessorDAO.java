/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.PreparedStatement;
import model.util.Conexao;
import model.database.entities.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class ProfessorDAO {
    
    public ArrayList<Professor> selectAllProfessores() {
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
        
    }
    
    public boolean insertProfessor(Professor user) {
        String sql;
        PreparedStatement stmt = null;                
        
        try {            
            
            Conexao conn = new Conexao();            
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario)"
                    + " VALUES (?, ?, ?, ?, ?)";
            
            stmt = conn.getConnection().prepareStatement(sql);                                   
            
            stmt.setString(1, user.getMatricula());
            stmt.setString(2, user.getNome_completo());
            stmt.setString(3, user.getSenha());
            stmt.setDate(4, new java.sql.Date(user.getData_nascimento().getTime()));
            stmt.setString(5, user.getTipo_usuario());                                                 
                        
            stmt.executeUpdate();        
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
}
