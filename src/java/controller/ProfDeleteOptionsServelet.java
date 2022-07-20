/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import model.database.dao.EmailUsuarioDAO;
import model.database.dao.ContatoUsuarioDAO;
import model.database.entities.ContatoUsuario;

/**
 *
 * Gerencia os pedidos de deleção dos formulários do perfil do professor
 * 
 * @author lieds
 */
@WebServlet(name = "ProfDeleteOptionsServelet", urlPatterns = {"/prof/DeletarEmailServelet", 
    "/prof/DeletarNumeroServelet"})
public class ProfDeleteOptionsServelet extends HttpServlet {

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
        
        String serveletPath = request.getServletPath();
        
        switch(serveletPath) {
            case "/prof/DeletarEmailServelet":
                this.deleteEmail(request, response);                                
                break;      
            case "/prof/DeletarNumeroServelet":                
                this.deleteCelular(request, response);
                break;
        }
                        
        response.sendRedirect("./tela_perfil_professor.html");
        
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
    
    /**
     * Deleta um e-mail cadastrado no banco de dados
     * 
     * @param request requisição do formulário de e-mail
     * @param response resposta da requisição
     * @return Boolean - Feedback se a operação foi bem sucedida
     * @throws IOException 
     */
    private boolean deleteEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String email = request.getParameter("email");
        boolean isEmailDeleted = new EmailUsuarioDAO().deleteEmail(email);
        
        return isEmailDeleted;
                
    }
        
    /**
     * Deleta um número de contato cadastrado no banco de dados
     * 
     * @param request
     * @param response
     * @return 
     */
    private boolean deleteCelular(HttpServletRequest request, HttpServletResponse response) {
        
        String numero = request.getParameter("numero");
        ContatoUsuario contato = new ContatoUsuario(1, numero);
        
        boolean isCelularDeleted = new ContatoUsuarioDAO().deleteContato(contato);
        
        return isCelularDeleted;
    } 
}
