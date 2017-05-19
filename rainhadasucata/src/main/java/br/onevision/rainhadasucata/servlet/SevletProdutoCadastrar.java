/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.servlet;

import br.onevision.rainhadasucata.model.Produto;
import br.onevision.rainhadasucata.service.ServiceProduto;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "SevletProdutoCadastrar", urlPatterns = {"/produto-cadastrar"})

public class SevletProdutoCadastrar extends HttpServlet {

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
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String descricao = request.getParameter("descricao");
        String valorCompra = request.getParameter("valor-compra");
        String margemLucro = request.getParameter("margem-lucro");
        String valorVenda = request.getParameter("valor-venda");
        String estoque = request.getParameter("estoque");
        String estoqueMinimo = request.getParameter("estoque-minimo");
        String status = request.getParameter("status");

        Produto p = new Produto();

        p.setNome(nome);
        p.setMarca(marca);
        p.setDescricao(descricao);
        p.setPrecoCompra(Double.parseDouble(valorCompra));
        
        try {
            p.setMargemVenda(Double.parseDouble(margemLucro));
        } catch (Exception e) {
            p.setMargemVenda(0);
        }
        
        p.setPrecoVenda(Double.parseDouble(valorVenda));
        p.setEstoque(Integer.parseInt(estoque));
        p.setEstoqueMinimo(Integer.parseInt(estoqueMinimo));

        if (status != null) {
            p.setStatus(1);

        } else {
            p.setStatus(0);
        }

        ServiceProduto serviceProduto = new ServiceProduto();

        try {
            if (serviceProduto.inserirProduto(p)) {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("novoProduto", nome);
                sessao.setAttribute("url", "http://localhost:8080/rainhadasucata/produto-cadastro.jsp");
                response.sendRedirect(request.getContextPath() + "/aciona-servlet-listar-produto.jsp");

            } else {
                HttpSession sessao = request.getSession();
                sessao.setAttribute("novoProduto", nome);
                sessao.setAttribute("url", "http://localhost:8080/rainhadasucata/produto-cadastro.jsp");

            }
        } catch (RuntimeException | SQLException ex) {

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

}
