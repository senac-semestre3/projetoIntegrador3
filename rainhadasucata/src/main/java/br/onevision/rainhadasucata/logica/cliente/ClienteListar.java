/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ClienteListar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Executando a logica ...");

        String busca = request.getParameter("busca");

        //cria lista de Clientes
        List<Cliente> clientes;

        // Chama o daoCliente
        DaoCliente dao = new DaoCliente();

        if (busca == null || busca.equals("")) {
            System.out.println("Busca vazia");
            clientes = dao.listarTodos();
        } else {
            try {
                Long.parseLong(busca.replace(".", ""));
                clientes = dao.listaPorCpfCnpj(busca);
                System.out.println("busca por cpf");
            } catch (Exception e) {
                clientes = dao.listaPorNome(busca);
                System.out.println("Busca por nome");
            }
        }
        // Guarda a lista no request
        request.setAttribute("clientes", clientes);

        System.out.println("Retornando o nome da página JSP ...");
        return "clientes.jsp";
    }
}
