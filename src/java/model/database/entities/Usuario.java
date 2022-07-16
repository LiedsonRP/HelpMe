/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;


import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import model.database.dao.UsuarioDAO;

/**
 *
 * @author lieds
 */
public abstract class Usuario {          
    
    private int id_usuario;
    protected String matricula;
    private String nome_completo;
    private String senha;    
    private Date data_nascimento;   
    private String tipo_usuario;        

    public Usuario(String nome_completo, String senha, String data_nascimento) {
        this.id_usuario = new UsuarioDAO().selectMaxID() + 1;        
        this.nome_completo = nome_completo;
        this.senha = senha;
        this.setData_nascimento(data_nascimento);        
    }    

    public Usuario() {
    }
            

    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public abstract void generateMatricula();

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            this.data_nascimento = formater.parse(data_nascimento);
        } catch (ParseException ex) {
            System.out.println("ERRO AO CONVERTER A DATA " + ex);;
        }
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }                

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_ususrio) {
        this.id_usuario = id_ususrio;
    }
        
}
