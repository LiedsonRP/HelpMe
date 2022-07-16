/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.util.Conexao;
import model.database.entities.EmailUsuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;;

/**
 *
 * @author lieds
 */
public class EmailUsuarioDAO {

    private Conexao conn;
    
    public EmailUsuarioDAO() {
        try {
            this.conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO EmailUsuarioDAO " + ex);
        }
    }
    
    
    
     /*public boolean insertUserEmail(EmailUsuario email) {
        String sql;
        PreparedStatement stmt = null;        
        
        try {            
            
            Conexao conn = new Conexao();            
            sql = "INSERT INTO usuario_email (fk_id_usuario, email)"
                    + " VALUES (?, ?)";
            
            stmt = conn.getConnection().prepareStatement(sql);                                   
            
            stmt.setInt(1, email.getId_usuario());
            stmt.setString(2, email.getEmail());            
                        
            stmt.executeUpdate();        
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }*/
     
    public boolean isUserEmailExists(String email) {                        
        
         try {             
             String sql = "SELECT * FROM usuario_email WHERE email LIKE + '" + email + "'";          
             
             ResultSet data = this.conn.executeQuery(sql);                        
             
             while (data.next()) {                 
                 return true;
             }
                          
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR O BANCO DE USUARIO");
         }
         
        return false;
    }
    
    /*public ArrayList<EmailUsuario> selectAllUsuarioEmailList(int usuario_id) {                
        ArrayList<EmailUsuario> emailUsuarioList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM usuario_email WHERE fk_id_usuario = ?";
            PreparedStatement stmt = new Conexao().getConnection().prepareStatement(sql);
         
            stmt.setInt(1, usuario_id);
            
            ResultSet data = stmt.executeQuery();
            
            while(data.next()) {
                EmailUsuario emailRegister = new EmailUsuario();
                emailRegister.setId_usuario(data.getInt("fk_id_usuario"));
                emailRegister.setEmail(data.getString("email"));
                emailRegister.setDescricao(data.getString("descricao"));
                emailUsuarioList.add(emailRegister);
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE E-MAIL");
         }
                                         
        return emailUsuarioList;
    }*/
        
}
