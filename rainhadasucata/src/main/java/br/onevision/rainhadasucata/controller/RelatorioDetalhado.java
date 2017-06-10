/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.controller;

import br.onevision.rainhadasucata.dao.DaoRelatorio;
import br.onevision.rainhadasucata.model.Relatorio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Willian Vieira
 */
@WebServlet(name = "RelatorioDetalhado", urlPatterns = {"/RelatorioDetalhado"})
public class RelatorioDetalhado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. 
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
  
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
        
        List<Relatorio> relatorioDetalhado = new  ArrayList<Relatorio>();
        String id = request.getParameter("id");
        System.out.println("ID "+id);
        try {
            DaoRelatorio relatorio = new DaoRelatorio();
            relatorioDetalhado = (List <Relatorio>) relatorio.obterDetalhesRelatorio(id);
            request.setAttribute("detalheRelatorio", relatorioDetalhado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("relatorios.jsp");
            dispatcher.forward(request, response);

            System.out.println("Detalhe "+relatorioDetalhado.get(0).getIdVenda());
            
        } catch (Exception e) {
            System.out.println("erro");
            System.out.println(e);
        }
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


}
