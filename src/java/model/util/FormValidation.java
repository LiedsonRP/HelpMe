/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import model.database.dao.EmailUsuarioDAO;

/**
 * Possui funções para validar os dados digitados em formulários
 * 
 * @author lieds
 */
public class FormValidation {
    
    /**
     * Verifica se um e-mail digitado existe no banco de dados
     * 
     * @param email - e-mail em formato String que será pesquisado
     * @return String - Retorna uma mensagem de erro caso o e-mail não seja encontrado, senão apenas uma variável vazia
     */
    public String checkEmailExists(String email) {        
        boolean isEmailExists = new EmailUsuarioDAO().isUserEmailExists(email);
        String message = "";
        
        if (isEmailExists) {
            message = "O E-mail digitado já está cadastrado!";
        }
        
        return message;        
    }
    
    /**
     * Compara duas Strings de senha para saber se são iguais
     * 
     * @param pass1 - String da senha1
     * @param pass2 - String da senha 2
     * @return String - Retorna uma mensagem de erro caso as senhas não sejam iguais, senão apenas uma variável vazia
     */
    public String comparePassword(String pass1, String pass2) {
        boolean isPassEqual = pass1.equals(pass2);
        
        String message = "";
        
        if (!isPassEqual) {
            message = "As senhas digitadas devem ser iguais";
        }
        
        return message;
    }
    
    /**
     * Verifica se uma senha possui o número de caracteres mínimos
     * 
     * @param minLenght tamanho mínimo que a String deve ter (int)
     * @param password senha digitada no formulário
     * @return String - Retorna uma mensagem de erro caso a String não possua o número de caracteres suficientes, senão apenas uma variável vazia
     */
    public String isMinLenght(int minLenght, String password) {
        int stringLenght = password.length();
        String message = "";
        
        if (stringLenght < minLenght) {
            message = "A senha deve ter no mínimo + " + minLenght + " caracteres!";
        }
                
        return message;
    }
       
}
