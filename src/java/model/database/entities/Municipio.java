/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 *
 * Classe que descreve um Município
 * 
 * @author lieds
 */
public class Municipio {
    private int id_cidade;
    private String nome_cidade;
    private int fk_id_estado;

    public int getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public int getFk_id_estado() {
        return fk_id_estado;
    }

    public void setFk_id_estado(int fk_id_estado) {
        this.fk_id_estado = fk_id_estado;
    }
        
}
