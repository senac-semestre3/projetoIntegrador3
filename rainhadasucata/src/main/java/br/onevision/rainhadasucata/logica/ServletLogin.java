/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Willian Vieira
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        try {
            DaoUsuario daoUsuario = new DaoUsuario();
            Usuario usuario = new Usuario();
            usuario = daoUsuario.obterNomeSenha(nome, senha);
            nome = usuario.getNome();
            System.out.println(usuario.getNomeUsuario());

            if (usuario.getNome() != null && usuario.getSenha() != null) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("sessionusuario", usuario);
              
                //trocar para request getdispacher
                response.sendRedirect("comum.jsp");

            }
        } catch (Exception e) {

            HttpSession sessao = request.getSession();
            sessao.setAttribute("session-usuario-n-encontrado", "1");
            response.sendRedirect("login.jsp");

        }

    }

}
