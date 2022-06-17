/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import java.text.ParseException;
import model.database.dao.EmailUsuarioDAO;
import model.database.dao.UsuarioDAO;
import model.database.entities.Usuario;

/**
 *
 * @author lieds
 */
public class Login {
    
    public Usuario login(String email, String senha) throws ParseException {        
        
        if (validateInfo(email, senha)) {
            //Retorna os dados do usuario para o front;
        }
        return null;
               
    }
    
    private boolean validateInfo(String email, String senha) throws ParseException {
        int user_id;       
        
        if(this.isEmailExist(email)) {
             user_id = new EmailUsuarioDAO().selectUserIdByEmail(email);
            if(isPasswordCorrect(user_id, senha)) {
                return true;
            }
        }
        
        return false;
    }        
    
    private boolean isEmailExist(String email) {
        boolean isEmailExists = new EmailUsuarioDAO().isUserEmailExists(email);        
        return isEmailExists;
    }
    
    private boolean isPasswordCorrect(int id_usuario, String password) throws ParseException {
        boolean isPasswordCorrect = false;
        Usuario user = new UsuarioDAO().selectUserById(id_usuario);        
        
        if (user.getSenha().equals(password)) {
            return true;
        }        
        
        return false;
    }
        
}
