/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.util;

import model.database.dao.AlunoDAO;
import model.database.dao.ProfessorDAO;
import model.database.dao.ContatoUsuarioDAO;
import model.database.dao.EmailUsuarioDAO;

import model.database.entities.Aluno;
import model.database.entities.Professor;
import model.database.entities.EmailUsuario;
import model.database.entities.ContatoUsuario;
/**
 *
 * @author lieds
 */
public class Cadastro {
    public boolean cadastrar(Aluno aluno, EmailUsuario email, ContatoUsuario contato) {
        boolean checkCadastro[] = new boolean[3]; 
        int checkedOK = 0;
        
        checkCadastro[0] = new AlunoDAO().insertAluno(aluno);
        /*checkCadastro[1] = new EmailUsuarioDAO().insertUserEmail(email);
        //checkCadastro[2] = new ContatoUsuarioDAO().insertUserContato(contato);
        
        for (boolean check : checkCadastro) {
            if (!check) {
                return false;
            }
        }*/
        
        if(!checkCadastro[0]) {
            return false;
        }
        return true;
    }
    
    public void cadastrar(Professor prof ,EmailUsuario email, ContatoUsuario contato) {
        new ProfessorDAO().insertProfessor(prof);
        new EmailUsuarioDAO().insertUserEmail(email);
        new ContatoUsuarioDAO().insertUserContato(contato);
    }
}
