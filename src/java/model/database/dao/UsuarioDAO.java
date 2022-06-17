/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.database.entities.Usuario;
import model.database.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.text.ParseException;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lieds
 */
public class UsuarioDAO {            
    public List<Usuario> selectAll() {                                        
        
        String sql;
        ArrayList<Usuario> usuarioList = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM usuario";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while (data.next()) {                
                Usuario user = new Usuario();                
                user.setMatricula(data.getString("matricula"));
                user.setNome_completo(data.getString("nome_completo"));                
                user.setData_nascimento(data.getDate("data_nascimento"));
                user.setTipo_usuario(data.getString("tipo_usuario"));
                user.setAutodescricao(data.getString("autodescricao"));
                
                usuarioList.add(user);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE USUARIO!" + ex);

        } catch (ParseException ex) {                                            
            System.out.println("ERRO AO PUXAR A DATA!");
        }
        
        return usuarioList;
    }
    
    public Usuario selectUserById(int id_user) throws ParseException {
        Usuario user = new Usuario();
        
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
            user.setAutodescricao(data.getString("autodescricao"));
            
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CHAMAR A BASE DE DADOS DE USUARIO!" + ex);
        }
                
        return user;
    }
    
    public boolean insertUser(Usuario user) {
        String sql;
        PreparedStatement stmt = null;        
        
        try {            
            
            Conexao conn = new Conexao();            
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario, autodescricao)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            
            stmt = conn.getConnection().prepareStatement(sql);                                   
            
            stmt.setString(1, user.getMatricula());
            stmt.setString(2, user.getNome_completo());
            stmt.setString(3, user.getSenha());
            stmt.setDate(4, new java.sql.Date(user.getData_nascimento().getTime()));
            stmt.setString(5, user.getTipo_usuario());
            stmt.setString(6, user.getAutodescricao());                                               
                        
            stmt.executeUpdate();        
            
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
                        
            ResultSet data = new Conexao().executeQuery(sql);                        
            
            data.next();
            maxID = data.getInt("maxID");                                  
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");            
        }
        
        return maxID;
    }
}
