/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.entities;

import model.util.CreateMatricula;

/**
 *
 * @author lieds
 */
public final class Aluno extends Usuario {
    private final String TIPO_USUARIO = "Aluno"; 
    private EmailUsuario alunoEmail;
    private ContatoUsuario alunoContato;

    public Aluno(String nome_completo, String senha, String data_nascimento) {
        super(nome_completo, senha, data_nascimento);                                
        this.setTipo_usuario(TIPO_USUARIO);
        this.generateMatricula();           
    } 

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

    @Override
    public void generateMatricula() {
        CreateMatricula matricGenerator = new CreateMatricula();
        String matricula = matricGenerator.createCodMatriculaAluno();
        
        this.matricula = matricula;
        System.out.println(matricula);
    }
    
}
