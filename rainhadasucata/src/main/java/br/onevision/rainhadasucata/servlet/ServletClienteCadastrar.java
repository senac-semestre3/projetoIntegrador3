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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ServletClienteCadastrar", urlPatterns = {"/cliente-cadastrar"})

public class ServletClienteCadastrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        String cpf = request.getParameter("cpf-cnpj");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setCpfCnpj(cpf);
        cliente.setSexo(sexo);
        cliente.setTelefone(telefone);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setLogradouro(logradouro);
        cliente.setNumero(numero);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setComplemento(complemento);
        cliente.setEstado(estado);

        DaoCliente daoCliente = null;
        try {
            daoCliente = new DaoCliente();
        } catch (SQLException ex) {
            Logger.getLogger(ServletClienteCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            daoCliente.inserir(cliente);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("clienteok", "1");

            response.sendRedirect("aciona-servlet-listar-cliente.jsp");
        } catch (Exception e) {

            HttpSession sessao = request.getSession();
            sessao.setAttribute("clienteok", "0");

            response.sendRedirect("aciona-servlet-listar-cliente.jsp");

        }

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
