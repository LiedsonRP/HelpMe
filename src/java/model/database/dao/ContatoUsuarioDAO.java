/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.database.entities.ContatoUsuario;
import model.util.Conexao;
/**
 *
 * Faz o CRUD com a tabela "usuario_contato" no banco de dados
 * 
 * @author lieds
 * 
 */
public class ContatoUsuarioDAO {
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public ContatoUsuarioDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO UsuarioDAO " + ex);
        }
    }
    
    /** 
     * Método que cadastra um contato de celular na base de dados
     * 
     * @param contato objeto do tipo ContatoUsuario que contém os dados de contato
     * @return Boolean - diz se a operação foi bem sucedida
     */
    public boolean insertUserContato(ContatoUsuario contato) {
        String sql;
        
        try {                                    
            sql = "INSERT INTO usuario_contato (fk_id_usuario, celular)"
                    + " VALUES ('" + contato.getId_usuario() + "', '" +
                    contato.getContato() + "')";
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    /** 
     * Pega todos os contatos cadastrados por um usuário usando o seu
     * id como referência no banco de dados
     * 
     * @param usuario_id id do usuário cadastrado (int)
     * @return ArrayList - Lista de contatos cadastrados no banco de dados no formato ContatoUsuario
     */
    public ArrayList<ContatoUsuario> selectAllUsuarioContatoList(int usuario_id) {                
        ArrayList<ContatoUsuario> contatoUsuarioList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM usuario_contato WHERE fk_id_usuario = " + usuario_id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                ContatoUsuario contato = new ContatoUsuario();
                contato.setId_usuario(data.getInt("fk_id_usuario"));
                contato.setContato(data.getString("celular"));
                contatoUsuarioList.add(contato);                
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE CONTATOS");
         }
                                         
        return contatoUsuarioList;
    }
    
    /**
     * Deleta as informações de um contato cadastrado no banco de dados
     * 
     * @param contato - Objeto com as informações do contato a ser apagado
     * @return Boolean - Feedback dizendo se a operação foi bem sucedida
     */
    public boolean deleteContato(ContatoUsuario contato) {        
        String sql;        
        
        try {            
                        
            sql = "DELETE FROM usuario_contato WHERE celular LIKE '" + contato.getContato()
                    + "' AND fk_id_usuario = " + contato.getId_usuario();                        
                    
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }
    }
    
    /**
     * Atualiza as informações de um contato
     * 
     * @param contato - Objeto com as informações do contato a ser atualizado
     * @param novoContato - String contendo o novo número de contato
     * @return 
     */
    public boolean updateContato(ContatoUsuario contato, String novoContato) {
        String sql;        
        
        try {            
                        
            sql = "UPDATE usuario_contato SET celular = '" + 
                    novoContato + "' WHERE celular LIKE '" + contato.getContato() 
                    + "' AND fk_id_usuario =" + contato.getId_usuario();                        
                    
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }        
    }

}
