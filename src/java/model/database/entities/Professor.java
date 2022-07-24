/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import java.util.ArrayList;
import model.util.CreateMatricula;

/**
 * Classe que descreve um usuário do tipo Professor
 * 
 * @author lieds
 */
public final class Professor extends Usuario {
    
    private final String TIPO_USUARIO = "Professor";
    
    private String cpf;
    private String Autodescricao;
    private ArrayList<ContatoUsuario> numCelularList = new ArrayList<>(); // Lista de contatos do professor
    private ArrayList<EmailUsuario> numEmailList = new ArrayList<>(); //LIsta de e-mails do professor
    private ArrayList<Disciplina> disciplinasList = new ArrayList<>(); //Lista de disciplinas lecionadas pelo professor
    private ArrayList<Ferramenta> ferramentasList = new ArrayList<>(); // Lista de ferramentas usadas pelo professor
    private ArrayList<CapacitacaoEspecial> capacitacaoEspecialList = new ArrayList<>(); //Lista de capacitações especiais
    private ArrayList<ProfessorHorario> profHorarioList = new ArrayList<>();//Lista de horários de um professor
    private String photo_file_path; //Caminho onde está armazenado a foto de perfil do professor, caso tenha
        
    /**
     * Construtor usado para gerar um novo Professor que será 
     * cadastrado no banco de dados
     * 
     * @param nome_completo - String contendo o nome do professor
     * @param senha - String contendo a senha do professor
     * @param data_nascimento - Data de nascimento do professor no formato java.util.Date
     */
    public Professor(String nome_completo, String senha, String data_nascimento) {
        super(nome_completo, senha, data_nascimento);
        this.generateMatricula();  
        this.setTipo_usuario(TIPO_USUARIO);
    }        

    /**
     * Construtor usado para quando a classe for apenas
     * para armazenar dados de um Professor já cadastrado
     */
    public Professor() {
    }
       
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAutodescricao() {
        return Autodescricao;
    }

    public void setAutodescricao(String Autodescricao) {
        this.Autodescricao = Autodescricao;
    }

    public ArrayList<ContatoUsuario> getNumCelularList() {
        return numCelularList;
    }

    public void setNumCelularList(ArrayList<ContatoUsuario> numCelularList) {
        this.numCelularList = numCelularList;
    }

    public ArrayList<EmailUsuario> getNumEmailList() {
        return numEmailList;
    }

    public void setNumEmailList(ArrayList<EmailUsuario> numEmailList) {
        this.numEmailList = numEmailList;
    }

    public String getPhoto_file_path() {
        return photo_file_path;
    }

    public void setPhoto_file_path(String photo_file_path) {
        this.photo_file_path = photo_file_path;
    }

    public ArrayList<Disciplina> getDisciplinasList() {
        return disciplinasList;
    }

    public void setDisciplinasList(ArrayList<Disciplina> disciplinasList) {
        this.disciplinasList = disciplinasList;
    }        

    public ArrayList<Ferramenta> getFerramentasList() {
        return ferramentasList;
    }

    public void setFerramentasList(ArrayList<Ferramenta> ferramentasList) {
        this.ferramentasList = ferramentasList;
    }        

    public ArrayList<CapacitacaoEspecial> getCapacitacaoEspecialList() {
        return capacitacaoEspecialList;
    }

    public void setCapacitacaoEspecialList(ArrayList<CapacitacaoEspecial> capacitacaoEspecialList) {
        this.capacitacaoEspecialList = capacitacaoEspecialList;
    }    

    public ArrayList<ProfessorHorario> getProfHorarioList() {
        return profHorarioList;
    }

    public void setProfHorarioList(ArrayList<ProfessorHorario> profHorarioList) {
        this.profHorarioList = profHorarioList;
    }
        
    
    /** 
     * Gera a matrícula de um Professor
     */
    @Override
    public void generateMatricula() {
        CreateMatricula matricGenerator = new CreateMatricula();
        String matricula = matricGenerator.createCodMatriculaProfessor();
        
        this.matricula = matricula;
    }
        
}
