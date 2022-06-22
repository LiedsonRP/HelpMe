/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.database.entities.ContatoUsuario;
import model.util.Conexao;
/**
 *
 * @author lieds
 */
public class ContatoUsuarioDAO {
    public boolean insertUserContato(ContatoUsuario contato) {
        String sql;
        PreparedStatement stmt = null;        
        
        try {            
            
            Conexao conn = new Conexao();            
            sql = "INSERT INTO usuario_contato (fk_id_usuario, celular)"
                    + " VALUES (?, ?)";
            
            stmt = conn.getConnection().prepareStatement(sql);                                   
            
            stmt.setInt(1, contato.getId_usuario());
            stmt.setString(2, contato.getContato());            
                        
            stmt.executeUpdate();        
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
}
