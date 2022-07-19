/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 *  Classe que descreve o contato de celular de um usuário
 * 
 * @author lieds
 */
public class ContatoUsuario {
    private int id_usuario;
    private String contato;    
    
    public ContatoUsuario(int id_usuario, String contato) {
        this.id_usuario = id_usuario;
        this.contato = contato;
    }

    public ContatoUsuario() {
    }        

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
