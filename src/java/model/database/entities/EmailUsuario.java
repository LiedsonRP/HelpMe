/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 * Classe que descreve as informações de e-mail de um usuário
 * 
 * @author lieds
 */
public class EmailUsuario {
    private int id_usuario;
    private String email;  

    public EmailUsuario(int id_usuario, String email) {
        this.id_usuario = id_usuario;
        this.email = email;
    }

    public EmailUsuario() {
    }    

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }       
}
