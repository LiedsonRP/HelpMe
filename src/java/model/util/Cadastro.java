/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import model.database.dao.UsuarioDAO;

import model.database.entities.Aluno;
import model.database.entities.Professor;
/**
 *
 * @author lieds
 */
public class Cadastro {      
    
    public boolean cadastrarAluno(String nomeUsuario, String usuarioSenha, String usuarioDataNasc, String usuarioEmail,
            String usuarioNumCelular) {
        
        Aluno aluno;
        boolean confirmCadastro;
        
        aluno = new Aluno(nomeUsuario, usuarioSenha, usuarioDataNasc);
        confirmCadastro = new UsuarioDAO().insertAluno(aluno);
        
        return confirmCadastro;
    }
        
    public boolean cadastrarProfessor(String nomeUsuario, String usuarioSenha, String usuarioDataNasc, String usuarioEmail,
            String usuarioNumCelular) {
                
        Professor professor;
        boolean confirmCadastro;
        
        professor = new Professor(nomeUsuario, usuarioSenha, usuarioDataNasc);
        confirmCadastro = new UsuarioDAO().insertProfessor(professor);
        
        return confirmCadastro;
    }
}
