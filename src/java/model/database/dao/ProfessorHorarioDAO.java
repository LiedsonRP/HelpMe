/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import model.util.Conexao;

import model.database.entities.ProfessorHorario;
import model.database.dao.DisciplinaDAO;
import model.database.entities.Disciplina;

/**
 *
 * @author lieds
 */
public class ProfessorHorarioDAO {
    
    private Conexao conn; //Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/    
    public ProfessorHorarioDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO professorDisciplinaDAO " + ex);
        }
    }
    
    public ArrayList<ProfessorHorario> selectAllHorariosFromProfessor(int id) {
        ArrayList<ProfessorHorario> horarioProfList = new ArrayList<>();
        
        try {            
            String sql = "SELECT * FROM professor_horario"
                    + " WHERE fk_id_usuario = " + id;         
            
            ResultSet data = this.conn.executeQuery(sql);
            
            while(data.next()) {
                ProfessorHorario horario = new ProfessorHorario();                                
                Time hora_inicio = data.getTime("hora_inicio"); 
                Time hora_fim = data.getTime("hora_fim");
                Disciplina disciplina = new DisciplinaDAO().selectDisciplinaByCodigo(data.getInt("fk_cod_disciplina"));
                
                horario.setId_horario(data.getInt("id_horario"));                
                horario.setDia_semana(data.getString("dia_semana"));
                horario.setForma_ensino(data.getString("forma_ensino"));
                horario.setHora_inicio(hora_inicio.toString());
                horario.setHora_fim(hora_fim.toString());
                horario.setId_usuario(data.getInt("fk_id_usuario"));
                horario.setDisciplina(disciplina);                
                
                horarioProfList.add(horario);
            }
         } catch (SQLException ex) {
             System.out.println("ERRO AO ACESSAR BANCO DE FERRAMENTAS DOS PROFESSORES");
         }
                                         
        return horarioProfList;
    }
}
