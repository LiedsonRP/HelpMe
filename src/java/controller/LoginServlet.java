/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.database.dao.EmailUsuarioDAO;
import model.database.dao.UsuarioDAO;

import model.database.dao.ContatoUsuarioDAO;
import model.database.entities.ContatoUsuario;

import model.database.entities.Aluno;
import model.database.entities.EmailUsuario;


/**
 * Servelet que valida formulário de Login e direciona
 * para a página de perfil correspondente a cada usuário
 * 
 * @author lieds
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String email = request.getParameter("login_email");//e-mail digitado no formulário
        String senha = request.getParameter("login_senha");//senha digitada no formulário                     
                
        //veririfica se o e-mail está cadastrado na base de dados
        boolean isEmailExists = new EmailUsuarioDAO().isUserEmailExists(email);
        
        if (isEmailExists) { 
            int userId = new EmailUsuarioDAO().getUserIdByEmail(email);
            String userPassword = new UsuarioDAO().getUserPasswordById(userId);
            
            //verifica se a senha digitada está correta
            if (userPassword.equals(senha)) {
                String tipo_usuario = new UsuarioDAO().getUserTypeById(userId);
                
                if (tipo_usuario.equals("Aluno")) { //Caso o tipo de usuário seja "Aluno"
                    Aluno aluno = new UsuarioDAO().selectAlunoById(userId);
                    
                    //Pega o email cadastrado pelo aluno
                    EmailUsuario alunoEmail = new EmailUsuarioDAO().selectAllUsuarioEmailList(userId).get(0);                    
                    aluno.setAlunoEmail(alunoEmail);
                    
                    //pega o telefone cadastrado pelo aluno
                    ContatoUsuario alunoContato = new ContatoUsuarioDAO().selectAllUsuarioContatoList(userId).get(0);
                    aluno.setAlunoContato(alunoContato);
                    
                    //redireciona para a página de perfil do aluno
                    response.sendRedirect("./aluno/perfil_aluno.html?Aluno=" + aluno);
                    
                } else if (tipo_usuario.equals("Professor")) { //Caso o tipo de usuário seja Professor
                    response.sendRedirect("./prof/tela_perfil_professor.html");
                }
            } else {
                //Manda a mensagem de erro de volta ao arquivo jsp;
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servelet que gerencia o formulário de Login";
    }// </editor-fold>
    
}
