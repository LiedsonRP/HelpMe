/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import model.database.Conexao;
import model.database.entities.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author lieds
 */
public class ProfessorDAO {
    
    public ArrayList<Usuario> selectAllProfessores() {
        ArrayList<Usuario> professorList = new ArrayList<>();
        
        try {                        
            
            String sql = "SELECT * FROM usuario WHERE tipo_usuario = 'Professor'";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while(data.next()) {
                Usuario user = new Usuario();
                user.setMatricula(data.getString("matricula"));
                user.setNome_completo(data.getString("nome_completo"));                
                user.setData_nascimento(data.getDate("data_nascimento"));
                user.setTipo_usuario(data.getString("tipo_usuario"));
                user.setAutodescricao(data.getString("autodescricao"));
                professorList.add(user);                
            }                        
                                            
        } catch (SQLException ex) {
            System.out.println("ERRO AO PESQUISAR PROFESSORES!");
        } catch (ParseException ex) {
            System.out.println("ERRO AO PUXAR A DATA");;
        }
                
        return professorList;
        
    }
}
