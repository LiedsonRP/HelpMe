/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.database.dao.ContatoUsuarioDAO;
import model.database.dao.EmailUsuarioDAO;
import model.database.dao.UsuarioDAO;
import model.database.dao.ProfessorDisciplinaDAO;
import model.database.dao.DisciplinaDAO;

import model.database.entities.Aluno;
import model.database.entities.ContatoUsuario;
import model.database.entities.Disciplina;
import model.database.entities.EmailUsuario;
import model.database.entities.Professor;

/**
 *
 * Preenche um usuário com as informações cadastradas no banco de dados
 * 
 * @author lieds
 */
public class CreateUsuarioPerfil {
    
    /**
     * Acessa as informações cadastradas de um professor 
     * para poder ser mostrado no perfil
     * 
     * @param id - id de identificação do professor (int)
     * @return Professor - Retorna um objeto do tipo Professor preenchido com os dados do banco
     */
    public Professor createProfessorById(int id) {            
        ArrayList<Disciplina> disciplinaList = new ArrayList<>();        
        
        Professor professor = new UsuarioDAO().selectProfessorById(id);
        
        //Pega os emails cadastrado pelo professor       
        professor.setNumEmailList(new EmailUsuarioDAO().selectAllUsuarioEmailList(id));
                    
        //pega os telefones cadastrado pelo professor        
        professor.setNumCelularList(new ContatoUsuarioDAO().selectAllUsuarioContatoList(id));
        
        //pega as disciplinas do professor
        for (Disciplina disc : new ProfessorDisciplinaDAO().selectAllDisciplinasFromProfessor(id)) {
            Disciplina disciplina = new DisciplinaDAO().selectDisciplinaByCodigo(disc.getCodigo_disciplina());
            disciplinaList.add(disciplina);
        }
        
        professor.setDisciplinasList(disciplinaList);                
        
        return professor;
    }
    
    /**
     * Acessa as informações cadastradas de um aluno 
     * para poder ser mostrado no perfil
     * 
     * @param id - id de identificação do aluno (int)
     * @return Aluno - Retorna um objeto do tipo Aluno preenchido com os dados do banco
     */
    public Aluno createAlunoById(int id) {
        
        Aluno aluno = new UsuarioDAO().selectAlunoById(id);
                    
        //Pega o email cadastrado pelo aluno
        EmailUsuario alunoEmail = new EmailUsuarioDAO().selectAllUsuarioEmailList(id).get(0);                    
        aluno.setAlunoEmail(alunoEmail);
                    
        //pega o telefone cadastrado pelo aluno
        ContatoUsuario alunoContato = new ContatoUsuarioDAO().selectAllUsuarioContatoList(id).get(0);
        aluno.setAlunoContato(alunoContato);
        
        return aluno;
    }
}
