/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.util.Conexao;
import model.database.entities.EmailUsuario;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;;

/**
 *
 * Faz o CRUD com a tabela "usuario_email" no banco de dados
 * 
 * @author lieds
 */
public class EmailUsuarioDAO {

    private Conexao conn;//Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/   
    public EmailUsuarioDAO() {
        try {
            this.conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO EmailUsuarioDAO " + ex);
        }
    }
    
    
    /**
     * Cadastra os dadosd e E-mail na base de dados
     * 
     * @param email objeto do tipo EmailUsuário que contém os dados de e-mail
     * @return Boolean - Feedback se a operação foi concluida com sucesso
     */
    public boolean insertUserEmail(EmailUsuario email) {
        String sql;        
        
        try {            
                        
            sql = "INSERT INTO usuario_email (fk_id_usuario, email)"
                    + " VALUES (+ '" + email.getId_usuario() + "', '" + email.getEmail() + "')";
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
     
    /**
     * Retorna o id de um usuário cadastrado no banco de dados
     * usando o e-mail como referência
     * 
     * @param email - e-mail usado como referencia no formato String
     * @return int - retorna o id do usuário
     */
    public int getUserIdByEmail(String email) {
        int id = 0;
        
        try {
            String sql = "SELECT fk_id_usuario as ID FROM usuario_email WHERE email LIKE + '" + email + "'";            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next();
            id = data.getInt("ID");
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");                        
        } finally {
            return id;
        }
    }
        
    /**
     * Verifica se um e-mail já está cadastrado
     * no banco de dados
     * 
     * @param email - e-mail à ser checado (String)
     * @return Boolean - Feedback dizendo se o e-mail já está cadastrado;
     */
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
    
    /**
     * Retorna todos os e-mail cadastrados no banco de dados
     * por um usuário específico na 
     * 
     * @param usuario_id - id do usuário que será usado como referência (int)
     * @return ArrayList - Lista com todos os e-mail cadastrados. Caso não haja ele retorna uma lista vazia do tipo EmailUsuário
     */
    public ArrayList<EmailUsuario> selectAllUsuarioEmailList(int usuario_id) {                
        ArrayList<EmailUsuario> emailUsuarioList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM usuario_email WHERE fk_id_usuario = " + usuario_id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                EmailUsuario emailRegister = new EmailUsuario();
                emailRegister.setId_usuario(usuario_id);
                emailRegister.setEmail(data.getString("email"));                
                emailUsuarioList.add(emailRegister);
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE E-MAIL");
         }
                                         
        return emailUsuarioList;
    }
    
    /**
     * Deleta um E-mail cadastrado no banco de dados
     * 
     * @param email - String contendo o e-mail a ser apagado
     * @return Boolean - Feedback dizendo se a operação foi concluida com sucesso
     */
    public boolean deleteEmail(String email) {        
        String sql;        
        
        try {            
                        
            sql = "DELETE FROM usuario_email WHERE email LIKE '" + email + "'";
                    
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }
    }
        
}
