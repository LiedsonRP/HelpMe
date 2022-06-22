/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class Professor extends Usuario {
    
    private final String TIPO_USUARIO = "Professor";
    
    private String cpf;
    private String Autodescricao;
    private ArrayList<ContatoUsuario> numCelularList = new ArrayList<>();
    private ArrayList<EmailUsuario> numEmailList = new ArrayList<>();
    private String photo_file_path;
    
    public Professor() {
        this.setTipo_usuario(TIPO_USUARIO);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAutodescricao() {
        return Autodescricao;
    }

    public void setAutodescricao(String Autodescricao) {
        this.Autodescricao = Autodescricao;
    }

    public ArrayList<ContatoUsuario> getNumCelularList() {
        return numCelularList;
    }

    public void setNumCelularList(ArrayList<ContatoUsuario> numCelularList) {
        this.numCelularList = numCelularList;
    }

    public ArrayList<EmailUsuario> getNumEmailList() {
        return numEmailList;
    }

    public void setNumEmailList(ArrayList<EmailUsuario> numEmailList) {
        this.numEmailList = numEmailList;
    }

    public String getPhoto_file_path() {
        return photo_file_path;
    }

    public void setPhoto_file_path(String photo_file_path) {
        this.photo_file_path = photo_file_path;
    }
        
}