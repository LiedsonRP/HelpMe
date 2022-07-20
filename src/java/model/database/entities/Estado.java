/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 *
 * Classe que descreve um Estado
 * 
 * @author lieds
 */
public class Estado {
    private int id_estado;
    private String sigla_uf;
    private String nome_uf;

    public int getId_estado() {
        return id_estado;
    }

    public String getSigla_uf() {
        return sigla_uf;
    }

    public String getNome_uf() {
        return nome_uf;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setSigla_uf(String sigla_uf) {
        this.sigla_uf = sigla_uf;
    }

    public void setNome_uf(String nome_uf) {
        this.nome_uf = nome_uf;
    }
        
}
