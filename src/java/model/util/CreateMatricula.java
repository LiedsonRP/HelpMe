/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import java.time.LocalDate;
import model.database.dao.UsuarioDAO;

/**
 *
 * @author lieds
 */
public class CreateMatricula {
    
    private final String PREFIXO_TIPO_ALUNO = "AL";
    private final String PREFIXO_TIPO_PROFESSOR = "PR";    
    private final int ANOATUAL = LocalDate.now().getYear();
    int LAST_USER_ID = new UsuarioDAO().selectMaxID();
    
    public String createCodMatriculaAluno() {        
        int next_id = LAST_USER_ID + 1;        
        String matricula = this.PREFIXO_TIPO_ALUNO + ANOATUAL + next_id;        
        
        return matricula;
    }
    
    public String createCodMatriculaProfessor() {
        int next_id = LAST_USER_ID + 1;
        String matricula = this.PREFIXO_TIPO_PROFESSOR + ANOATUAL + next_id; 
        
        return matricula;
    }        
    
}
