/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.util.Conexao;
import model.database.entities.Aluno;

/**
 *
 * @author lieds
 */
public class UsuarioDAO {
    
    public List<Aluno> selectAllUsers() {                                        
        
        String sql;
        ArrayList<Aluno> usuarioList = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM usuario";
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
    
    public Aluno selectUserById(int id_user) throws ParseException {
        Aluno user = new Aluno();
        
        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
            PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id_user);
            
            ResultSet data = stmt.executeQuery();
            data.next();
            
            user.setId_usuario(id_user);
            user.setMatricula(data.getString("matricula"));
            user.setNome_completo(data.getString("nome_completo"));
            user.setSenha(data.getString("senha"));
            user.setData_nascimento(data.getDate("data_nascimento"));
            user.setTipo_usuario(data.getString("tipo_usuario"));            
            
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE USUARIO!" + ex);
        }
                
        return user;
    }
    
    public int selectMaxID() {
        int maxID = 0;
        
        try {
            String sql = "SELECT MAX(id_usuario) as maxID FROM usuario";            
                        
            ResultSet data = new Conexao().executeQuery(sql);                        
            
            data.next();
            maxID = data.getInt("maxID");                                  
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");            
        }
        
        return maxID;
    }
    
    public String getSenhaUsuarioById(int id_usuario) {
        String password = "";
        
        try {
            String sql = "SELECT senha as senha FROM usuario WHERE id_usuario = ?";            
            PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
            
            stmt.setInt(1, id_usuario);
            
            ResultSet data = stmt.executeQuery();                        
            
            data.next();
            
            password = data.getString("senha");
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O SENHA!");            
        }

        return password;
        
    }
        
}
