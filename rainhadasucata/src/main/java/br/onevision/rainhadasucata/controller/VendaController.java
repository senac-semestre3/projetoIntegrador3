/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.controller;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class VendaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {

        String busca = request.getParameter("busca");
        String destino;
        
        try {
            int id = Integer.parseInt(busca);

            Produto produto;
            DaoProduto dao = new DaoProduto();

            produto = dao.obter(id);
            destino = produto.toJSON().toJSONString();

        } catch (NumberFormatException | IOException e) {
            Produto produto;
            DaoProduto dao = new DaoProduto();

            produto = dao.obter(0);
            destino = produto.toJSON().toJSONString();
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println(destino);
        }

    }
    
}