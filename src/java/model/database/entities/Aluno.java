/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import model.database.dao.UsuarioDAO;
import model.util.CreateMatricula;

/**
 *
 * @author lieds
 */
public class Aluno extends Usuario {
    private final String TIPO_USUARIO = "Aluno";    
    
    
    public Aluno() {
        this.setId_usuario(new UsuarioDAO().selectMaxID() + 1);        
        this.setMatricula(new CreateMatricula().createCodMatriculaAluno());
        this.setTipo_usuario(TIPO_USUARIO);
    }
    
}
