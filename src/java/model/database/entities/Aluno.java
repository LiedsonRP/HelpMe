/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import model.util.CreateMatricula;

/**
 * Classe que descreve um usuário do tipo Aluno
 * 
 * @author lieds
 */
public final class Aluno extends Usuario {
    private final String TIPO_USUARIO = "Aluno"; 
    private EmailUsuario alunoEmail;
    private ContatoUsuario alunoContato;

    /**
     * Construtor usado para gerar um novo Aluno que será 
     * cadastrado no banco de dados
     * 
     * @param nome_completo - String contendo o nome do aluno
     * @param senha - String contendo a senha do aluno
     * @param data_nascimento - Data de nascimento do aluno no formato java.util.Date
     */
    public Aluno(String nome_completo, String senha, String data_nascimento) {
        super(nome_completo, senha, data_nascimento);                                
        this.setTipo_usuario(TIPO_USUARIO);
        this.generateMatricula();           
    } 

    /**
     * Construtor usado para quando a classe for apenas
     * para armazenar dados de um Aluno já cadastrado
     */
    public Aluno() {
    }

    public EmailUsuario getAlunoEmail() {
        return alunoEmail;
    }

    public void setAlunoEmail(EmailUsuario alunoEmail) {
        this.alunoEmail = alunoEmail;
    }

    public ContatoUsuario getAlunoContato() {
        return alunoContato;
    }

    public void setAlunoContato(ContatoUsuario alunoContato) {
        this.alunoContato = alunoContato;
    }

    /**
     *  Gera a matrícula de um aluno
     */
    @Override
    public void generateMatricula() {
        CreateMatricula matricGenerator = new CreateMatricula();
        String matricula = matricGenerator.createCodMatriculaAluno();
        
        this.matricula = matricula;
        System.out.println(matricula);
    }
    
}
