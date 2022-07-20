/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

/**
 *
 * Classe que descreve uma disciplina
 * 
 * @author lieds
 */
public class Disciplina {
    private int codigo_disciplina;
    private String nome_disciplina;    

    public Disciplina() {
    }        

    public String getNome_disciplina() {
        return nome_disciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nome_disciplina = nome_disciplina;
    }

    public int getCodigo_disciplina() {
        return codigo_disciplina;
    }

    public void setCodigo_disciplina(int codigo_disciplina) {
        this.codigo_disciplina = codigo_disciplina;
    }       
    
}