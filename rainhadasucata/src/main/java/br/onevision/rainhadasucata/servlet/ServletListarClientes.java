/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.servlet;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.model.Cliente;
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
@WebServlet("/servlet-listar-clientes")
public class ServletListarClientes extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException {
    
    String papel = request.getParameter("papel");
    request.setAttribute("papelUsuario", papel);

    // Efetua o processamento (neste caso, recuperar
    // a lista de contatos do banco
    //ContatoDAO dao = new ContatoDAO();
    //List<Contato> lista = dao.listar();
   List<Cliente> lista = new ArrayList<>();
    
      try {
   
                 DaoCliente daocliente = new DaoCliente();
          lista = daocliente.listarTodos();
          
              request.setAttribute("listaContatos", lista);
    
    // Lógica para encaminhar a requisição para continuar
    // o processamento no JSP.
    RequestDispatcher dispatcher =   request.getRequestDispatcher("clientes.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }
          
      } catch (SQLException ex) {
          Logger.getLogger(ServletListarClientes.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Exception ex) {
          Logger.getLogger(ServletListarClientes.class.getName()).log(Level.SEVERE, null, ex);
      }
   
    // Define um atributo para repassar a lista para o
    // JSP
   
    // Define um atributo para repassar a lista para o
    // JSP


  }

}
