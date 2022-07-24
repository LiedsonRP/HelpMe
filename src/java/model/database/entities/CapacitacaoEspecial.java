/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 *
 * Classe que descreve uma capacitação especial de um professor
 * 
 * @author lieds
 */
public class CapacitacaoEspecial {
    private String nome_capacitEspecial;
    private int id_usuario;
    private int id_condicaoEspecial;

    public String getNome_capacitEspecial() {
        return nome_capacitEspecial;
    }

    public void setNome_capacitEspecial(String nome_capacitEspecial) {
        this.nome_capacitEspecial = nome_capacitEspecial;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }      

    public int getId_condicaoEspecial() {
        return id_condicaoEspecial;
    }

    public void setId_condicaoEspecial(int id_condicaoEspecial) {
        this.id_condicaoEspecial = id_condicaoEspecial;
    }
    
    
    
}
