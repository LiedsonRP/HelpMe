/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import model.database.dao.EmailUsuarioDAO;

/**
 *
 * @author lieds
 */
public class FormValidation {
    
    public boolean checkEmailExists(String email) {        
        return new EmailUsuarioDAO().isUserEmailExists(email);
    }
    
    public boolean comparePassword(String pass1, String pass2) {
        return pass1.equals(pass2);
    }
       
}
