/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.servlet;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Conversao;
import br.onevision.rainhadasucata.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

/**
 *
 * @author willian.mvieira
 */
@WebServlet(name = "ServletUsuarioCadastrar", urlPatterns = {"/usuario-cadastrar"})

public class ServletUsuarioCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("entrada.jsp");
        dispatcher.forward(request, response);
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

        // Recupera os dados enviados na requisi��o.
        // Notar que o valor passado no getParameter()
        // tem que ser igual ao valor configurado no 
        // atributo "name" da tag <input>
        Conversao conversao = new Conversao();
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String usuarioNome = request.getParameter("usuario-nome");
        String senha = request.getParameter("usuario-senha");
        // String datanasc = request.getParameter(conversao.dataDb("data-nascimento"));
        String permissao = request.getParameter("permissao");
        String status = request.getParameter("status");
        String lojaId = request.getParameter("lojas");

        Usuario usuario = new Usuario();

        usuario.setNome(nome);

        usuario.setCpfCnpj(cpf);
        usuario.setSexo(sexo);
        usuario.setTelefone(telefone);
        usuario.setCelular(celular);
        usuario.setEmail(email);
        usuario.setNomeUsuario(usuarioNome);
        usuario.setSenha(senha);
        usuario.setDataNascimento("2017-05-02");
        usuario.setIdPermissao(Integer.parseInt(permissao));
        usuario.setIdLoja(Integer.parseInt(lojaId));

        if (status != null) {
            usuario.setStatus(1);

        } else {
            usuario.setStatus(0);
        }

        DaoUsuario daoUsuario = null;
        try {
            daoUsuario = new DaoUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(ServletUsuarioCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        daoUsuario.inserir(usuario);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoUsuario", usuario);
        sessao.setAttribute("url", "http://localhost:8080/rainhadasucata/usuario-cadastro.jsp");
        response.sendRedirect(request.getContextPath() + "/resposta_usuario.jsp");

    }
    //  String senha = request.getParameter("senha");
//        request.setAttribute("nome", senha);
//        request.setAttribute("senha", nome);
//        DaoCliente daoCliente = new DaoCliente();
//
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("login.jsp");
//
//        dispatcher.forward(request, response);
    // Cria um novo contato e salva
    // Usa a sessao para manter os dados ap�s
    // redirect (t�cnica POST-REDIRECT-GET),
    // usado para evitar dupla submiss�o dos
    // dados

    //  String senha = request.getParameter("senha");
//        request.setAttribute("nome", senha);
//        request.setAttribute("senha", nome);
//        DaoCliente daoCliente = new DaoCliente();
//
//        RequestDispatcher dispatcher
//                = request.getRequestDispatcher("login.jsp");
// 
//        dispatcher.forward(request, response);
    // Cria um novo contato e salva
    // Usa a sessao para manter os dados ap�s
    // redirect (t�cnica POST-REDIRECT-GET),
    // usado para evitar dupla submiss�o dos
    // dados
}
