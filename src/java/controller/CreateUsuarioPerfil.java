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
import model.database.dao.ProfessorFerramentaDAO;
import model.database.dao.ProfessorCapacitacaoEspecialDAO;
import model.database.dao.ProfessorHorarioDAO;

import model.database.entities.Aluno;
import model.database.entities.ContatoUsuario;
import model.database.entities.Disciplina;
import model.database.entities.EmailUsuario;
import model.database.entities.Professor;
import model.database.entities.Ferramenta;
import model.database.entities.CapacitacaoEspecial;
import model.database.entities.ProfessorHorario;

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
        ArrayList<Ferramenta> ferramentaList = new ArrayList<>();
        ArrayList<CapacitacaoEspecial> capacitacaoList = new ArrayList<>();
        ArrayList<ProfessorHorario> horarioList = new ArrayList<>();
        
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
        
        //pega as ferramentas dos professores
        for (Ferramenta ferramenta : new ProfessorFerramentaDAO().selectAllFerramentasFromProfessor(id)) {                                    
            ferramentaList.add(ferramenta);
        }
        
        professor.setFerramentasList(ferramentaList);
        
        //pega as capacitações dos professores
        for (CapacitacaoEspecial capacitacao : new ProfessorCapacitacaoEspecialDAO().selectAllCapacitacaoFromProfessor(id)) {
            capacitacaoList.add(capacitacao);            
        }            
        
        professor.setCapacitacaoEspecialList(capacitacaoList);                
        
        //pega as informações de horário do professor
        for (ProfessorHorario horario : new ProfessorHorarioDAO().selectAllHorariosFromProfessor(id)) {
            horarioList.add(horario);            
        }
        
        professor.setProfHorarioList(horarioList);
        
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
