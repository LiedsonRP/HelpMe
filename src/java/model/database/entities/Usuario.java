/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class Usuario {          
    
    private int id_usuario;
    private String matricula;
    private String nome_completo;
    private String senha;
    private String tipo_usuario;
    private Date data_nascimento;    
    private String autodescricao;
    private ArrayList<ContatoUsuario> numCelularList = new ArrayList<>();
    private ArrayList<EmailUsuario> numEmailList = new ArrayList<>();

    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

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

    public void setData_nascimento(String data_nascimento) throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        this.data_nascimento = formater.parse(data_nascimento);
    }

    public void setData_nascimento(Date data_nascimento) throws ParseException {        
        this.data_nascimento = data_nascimento;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }            

    public String getAutodescricao() {
        return autodescricao;
    }

    public void setAutodescricao(String autodescricao) {
        this.autodescricao = autodescricao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_ususrio) {
        this.id_usuario = id_ususrio;
    }
        
}
