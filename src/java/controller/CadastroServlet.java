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
import java.io.PrintWriter;

import model.database.dao.ContatoUsuarioDAO;
import model.database.entities.ContatoUsuario;
import model.database.dao.EmailUsuarioDAO;
import model.database.entities.EmailUsuario;
import model.database.entities.Aluno;
import model.database.dao.UsuarioDAO;

import model.util.FormValidation;

/**
 *
 * Servelet que valida os dados do formulário de Cadastro de Usuário,
 * Cadastra e direciona para as páginas correspondentes
 * 
 * @author lieds
 */
@WebServlet(name = "CadastroServlet", urlPatterns = {"/CadastroServlet"})
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
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */          
        }
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
        
        //Dados vindos do formulário de cadastro
        String nomeUsuario = request.getParameter("cadastro_nome");
        String usuarioSenha = request.getParameter("cadastro_senha");
        String usuarioRepitaSenha = request.getParameter("cadastro_repita_senha");
        String usuarioData_Nascimento = request.getParameter("cadastro_data_nasc");
        String usuarioEmail = request.getParameter("cadastro_email");
        String usuarioNumCelular = request.getParameter("cadastro_celular");
        String tipoUsuario = request.getParameter("cargo");  
               
        String errorMsg; // Mensagem de erro
        
        //Validações de formulário vindas da classe FormValidation
        errorMsg = new FormValidation().checkEmailExists(usuarioEmail); 
        errorMsg = new FormValidation().isMinLenght(8, usuarioSenha);
        errorMsg = new FormValidation().comparePassword(usuarioSenha, usuarioRepitaSenha);
                
        //Verifica se existe alguma mensagem de erro
        if (!errorMsg.isEmpty()) { //Caso "true", retorna para a home junto da mensagem
            response.sendRedirect("index.jsp?error=" + errorMsg);
        }  else {
            //Verifica o tipo de Usuário para fazer o cadastro caso "errorMsg" esteja vazia
            if (tipoUsuario.equals("aluno")) { //Caso tipo de usuário seja "Aluno"  
            
                Aluno aluno = new Aluno(nomeUsuario, usuarioSenha, usuarioData_Nascimento);
                EmailUsuario email = new EmailUsuario(aluno.getId_usuario(), usuarioEmail);
                ContatoUsuario contato = new ContatoUsuario(aluno.getId_usuario(), usuarioNumCelular);
                
                boolean hasCadastroSuccefully = false; //Variável que armazena o resultados dos cadastros
                
                //Lista armazenando os resultados dos cadastros feitos no banco de dados após sua execução
                boolean confirmCadastroList[] = {new UsuarioDAO().insertAluno(aluno),
                new EmailUsuarioDAO().insertUserEmail(email), 
                new ContatoUsuarioDAO().insertUserContato(contato)};

                //Checa se ocorreu um erro em algum cadastro
                for (boolean confirmCadastro : confirmCadastroList) {
                    if (confirmCadastro) {
                        hasCadastroSuccefully = true;
                    } else {
                        hasCadastroSuccefully = false;
                        break;
                    }
                }

                //Caso não tenha ocorrido, direciona para o perfil do aluno
                if (hasCadastroSuccefully) {
                    response.sendRedirect("./aluno/perfil_aluno.html");
                } 
            
            } else {
                //Redirecionar o professor para o segundo formulário            
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
        return "Servelet que valida os dados do formulário de Cadastro de Usuário,\n" +
"Cadastra e direciona para as páginas correspondentes";
    }// </editor-fold>

}
