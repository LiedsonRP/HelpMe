/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.database.entities.Aluno;
import model.database.entities.Professor;
import model.database.entities.EmailUsuario;
import model.database.entities.ContatoUsuario;
import model.util.Cadastro;



/**
 *
 * @author lieds
 */
public class CadastroServlet extends HttpServlet {

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
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        boolean goneCadastrado = false;
        EmailUsuario userEmail = new EmailUsuario();
        ContatoUsuario userContato = new ContatoUsuario();
        
        String nome = request.getParameter("cadastro_nome");
        String senha = request.getParameter("cadastro_senha");
        String data = request.getParameter("cadastro_data_nasc");
        String emailForm = request.getParameter("cadastro_email");
        String contatoForm = request.getParameter("cadastro_celular");
        String tipo_usuario = request.getParameter("cargo");
        
        if (tipo_usuario.equals("Aluno")) {
            Aluno aluno = new Aluno();
            
            aluno.setNome_completo(nome);            
            aluno.setSenha(senha);
            
            try {
                aluno.setData_nascimento(data);
            } catch (ParseException ex) {
                Logger.getLogger(CadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
            }             
            
            /*
            userEmail.setId_usuario(aluno.getId_usuario());
            userEmail.setEmail(emailForm);
            
            userContato.setId_usuario(aluno.getId_usuario());
            userContato.setContato(contatoForm);*/
            
            goneCadastrado = new Cadastro().cadastrar(aluno, userEmail, userContato);
        }
        
        if (goneCadastrado) {            
            response.sendRedirect("./perfil.html");
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
