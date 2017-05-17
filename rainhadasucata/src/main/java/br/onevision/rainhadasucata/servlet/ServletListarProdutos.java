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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet("/servlet-listar-produtos")
public class ServletListarProdutos extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException {
    

   List<Produto> lista = new ArrayList<>();
    
      try {
   
                 DaoProduto daocliente = new DaoProduto();
          lista = daocliente.listarTodos();
          
              request.setAttribute("listaProdutos", lista);
    
    // Lógica para encaminhar a requisição para continuar
    // o processamento no JSP.
    RequestDispatcher dispatcher =   request.getRequestDispatcher("produtos.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }
          
      } catch (SQLException ex) {
          Logger.getLogger(ServletListarProdutos.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
          Logger.getLogger(ServletListarProdutos.class.getName()).log(Level.SEVERE, null, ex);
      }
   
   
  }

}
