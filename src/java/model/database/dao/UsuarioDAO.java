/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.database.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.util.Conexao;
import model.database.entities.Aluno;
import model.database.entities.Professor;

/**
 * Faz o CRUD com a tabela "usuario" no banco de dados
 * 
 * @author lieds
 */
public class UsuarioDAO {
    
    private Conexao conn;//Variável usada para gerar a conexão com o banco de dados
    
    /** Método construtor que cria a conexão com o banco de dados*/ 
    public UsuarioDAO() {
        try {
            conn = new Conexao("localhost", "helpmedb", "root", "1234");
        } catch (SQLException ex) {
            System.out.println("ERRO AO FAZER A CONEXÃO PELO UsuarioDAO " + ex);
        }
    }
    
    /**
     * Retorna a senha de um usuário cadastrado no banco de dados
     * usando o codigo id.
     * 
     * @param id - id usado como referência de busca (int)
     * @return String - senha cadastrada
     */
    public String getUserPasswordById(int id) {
        
        String password = "";
        
        try {
            String sql = "SELECT senha FROM usuario WHERE id_usuario = " + id;            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next();
            password = data.getString("senha");
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");                        
        } finally {
            return password;
        }
                
    }
    
    /**
     * Retorna o tipo de usuário
     * usando o codigo id como referência.
     * 
     * @param id - id usado como referência de busca (int)
     * @return String - retorna o tipo de usuário do id
     */
    public String getUserTypeById(int id) {
        String tipo_usuario = "";
        
        try {
            String sql = "SELECT tipo_usuario FROM usuario WHERE id_usuario = " + id;            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next();
            tipo_usuario = data.getString("tipo_usuario");
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O TIPO DE USUÁRIO!");                        
        } finally {
            return tipo_usuario;
        }
    }
    
    /**
     * Retorna o maior Id cadastrado no banco de dados
     * 
     * @return Int - retorna o maior id cadastrado no banco de dados
     */
    public int selectMaxID() {
        int maxID = 0;
        
        try {
            String sql = "SELECT MAX(id_usuario) as maxID FROM usuario";            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next();
            maxID = data.getInt("maxID");                                  
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O ID!");            
        }
        
        return maxID;
    }
  
                            
    
    //USUÁRIO PROFESSOR
    
    /*public ArrayList<Professor> selectAllProfessores() {
        ArrayList<Professor> professorList = new ArrayList<>();
        
        try {                        
            
            String sql = "SELECT * FROM usuario WHERE tipo_usuario LIKE 'Professor'";
            ResultSet data = new Conexao().executeQuery(sql);
            
            while(data.next()) { 
                Professor user = new Professor();
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
        
    }*/
    
    /**
     * Cadastra um usuário do tipo Professor no Banco de Dados     
     * 
     * @param user - Guarda as informações do objeto Professor
     * @return Boolean - Feedback informando se o cadastro foi bem sucedido
     */
    public boolean insertProfessor(Professor user) {
        String sql;    
        Date dataDB_Format = new Date(user.getData_nascimento().getTime());
        
        try {                        
                                   
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario)"
                    +" VALUES ('" + user.getMatricula() + "', '" +
                    user.getNome_completo() + "', '" +
                    user.getSenha() + "', '" +
                    dataDB_Format + "', '" +
                    user.getTipo_usuario() + "')";                         
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    /**
     * Busca as informações de um professor no banco de dados usando o id 
     * como parâmetro de pesquisa
     * 
     * @param id - id do professor
     * @return Professor - Objeto do tipo Professor contendo as informações cadastradas no banco de dados
     */
    public Professor selectProfessorById(int id) {
        Professor professor = new Professor();                
        
        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario = " + id;            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next(); 
            
            professor.setId_usuario(data.getInt("id_usuario"));
            professor.setMatricula(data.getString("matricula"));
            professor.setNome_completo(data.getString("nome_completo"));
            professor.setSenha(data.getString("nome_completo"));
            professor.setData_nascimento(data.getString("data_nascimento"));
            professor.setTipo_usuario(data.getString("tipo_usuario"));
            professor.setAutodescricao(data.getString("autodescricao"));
            professor.setCpf(data.getString("cpf"));
            professor.setPhoto_file_path(data.getString("foto_perfil"));
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O USUÁRIO!");                        
        } finally {
            return professor;
        }                 
    }
    
    //USUÁRIO ALUNO
    
    /**
     * Cadastra um usuário do tipo Aluno no Banco de Dados
     * 
     * @param user - Guarda as informações do objeto Aluno
     * @return Boolean - Feedback informando se o cadastro foi bem sucedido
     */
     public boolean insertAluno(Aluno user) {
        String sql;    
        Date dataDB_Format = new Date(user.getData_nascimento().getTime());
        
        try {                        
                                   
            sql = "INSERT INTO usuario (matricula, nome_completo, senha, data_nascimento, tipo_usuario)"
                    +" VALUES ('" + user.getMatricula() + "', '" +
                    user.getNome_completo() + "', '" +
                    user.getSenha() + "', '" +
                    dataDB_Format + "', '" +
                    user.getTipo_usuario() + "')";                         
            
            this.conn.executeUpdate(sql);
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO EXECUTAR O UPDTADE!" + ex);
            return false;
        }                
    }
    
    /**
     * Retorna as informações cadastradas de um Aluno
     * na tabela Usuário do Banco de Dados
     * 
     * @param id - id de usuário usado como referência de pesquisa
     * @return Aluno - Retorna um objeto do tipo professor contendo as informações cadastradas na tabela professor
     */
    public Aluno selectAlunoById(int id) {
        Aluno aluno = new Aluno();                
        
        try {
            String sql = "SELECT * FROM usuario WHERE id_usuario = " + id;            
                        
            ResultSet data = conn.executeQuery(sql);                        
            
            data.next(); 
            
            aluno.setId_usuario(data.getInt("id_usuario"));
            aluno.setMatricula(data.getString("matricula"));
            aluno.setSenha(data.getString("nome_completo"));
            aluno.setData_nascimento(data.getString("data_nascimento"));
            aluno.setTipo_usuario(data.getString("tipo_usuario"));  
            
        } catch (SQLException ex) {
            System.out.println("ERRO AO CAPTURAR O USUÁRIO!");                        
        } finally {
            return aluno;
        }                 
    }
}
