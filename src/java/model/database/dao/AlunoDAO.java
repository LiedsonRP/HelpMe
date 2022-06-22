/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.database.entities.Aluno;
import model.util.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.text.ParseException;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class AlunoDAO extends UsuarioDAO {            
    public List<Aluno> selectAllAlunos() {                                        
        
        String sql;
        ArrayList<Aluno> usuarioList = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM usuario WHERE tipo_usuario LIKE 'Aluno'";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while (data.next()) {                
                Aluno user = new Aluno();                
                user.setMatricula(data.getString("matricula"));
                user.setNome_completo(data.getString("nome_completo"));                
                user.setData_nascimento(data.getDate("data_nascimento"));
                user.setTipo_usuario(data.getString("tipo_usuario"));                
                
                usuarioList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE USUARIO!" + ex);

        } catch (ParseException ex) {                                            
            System.out.println("ERRO AO PUXAR A DATA!");
        }
        
        return usuarioList;
    }                
    
    public boolean insertAluno(Aluno user) {
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
