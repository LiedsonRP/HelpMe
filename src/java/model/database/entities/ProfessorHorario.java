/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;


/**
 *
 * @author lieds
 */
public class ProfessorHorario {
    private int id_horario;
    private String dia_semana;
    private String forma_ensino;
    private String hora_inicio;
    private String hora_fim;
    private int id_usuario;
    private Disciplina disciplina;

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public String getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }

    public String getForma_ensino() {
        return forma_ensino;
    }

    public void setForma_ensino(String forma_ensino) {
        this.forma_ensino = forma_ensino;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {        
        this.hora_inicio = hora_inicio.substring(0, 5);
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim.substring(0, 5);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }    
    
}
