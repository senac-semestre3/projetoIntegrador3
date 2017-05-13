/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.servlet;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Produto;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "ServletLogin", urlPatterns = {"/login"})
public class ServletLogin extends HttpServlet {

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

        Cliente c = new Cliente();

        DaoProduto pDao = new DaoProduto();

        // Recupera os dados enviados na requisição.
        // Notar que o valor passado no getParameter()
        // tem que ser igual ao valor configurado no 
        // atributo "name" da tag <input>
        String nome = request.getParameter("nome");

        Produto p = new Produto();

        p.setNome(nome);
        //pDao.listaPorNome(p);

        String senha = request.getParameter("senha");

        request.setAttribute("nome", senha);
        request.setAttribute("senha", nome);
        DaoCliente daoCliente = new DaoCliente();

        c.setNome(nome);
        daoCliente.inserir(c);

        System.out.println(nome);
        System.out.println(senha);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("login.jsp");

        dispatcher.forward(request, response);
        // Cria um novo contato e salva

        // Usa a sessao para manter os dados após
        // redirect (técnica POST-REDIRECT-GET),
        // usado para evitar dupla submissão dos
        // dados
    }

}
