/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import java.time.LocalDate;
import model.database.dao.UsuarioDAO;

/**
 * Classe que gerencia a criação do código de matrícula dos usuários
 * 
 * @author lieds
 */
public class CreateMatricula {
    
    private final String PREFIXO_TIPO_ALUNO = "AL"; 
    private final String PREFIXO_TIPO_PROFESSOR = "PR";    
    private final int ANOATUAL = LocalDate.now().getYear(); //Pega o ano atual de cadastro
    int LAST_USER_ID = new UsuarioDAO().selectMaxID(); //Guarda o ultimo id cadastrado na tabela "usuario" do banco de dados
    
    /**
     * Cria o código de matrícula do tipo de usuário "Aluno"
     * 
     * @return String - Código de matrícula do aluno
     */
    public String createCodMatriculaAluno() {        
        int next_id = LAST_USER_ID + 1;        
        String matricula = this.PREFIXO_TIPO_ALUNO + ANOATUAL + next_id;        
        
        return matricula;
    }
    
    /**
     * Cria o código de matrícula do tipo de usuário "Professor"
     * 
     * @return String - Código de matrícula do Professor
     */
    public String createCodMatriculaProfessor() {
        int next_id = LAST_USER_ID + 1;
        String matricula = this.PREFIXO_TIPO_PROFESSOR + ANOATUAL + next_id; 
        
        return matricula;
    }        
    
}
