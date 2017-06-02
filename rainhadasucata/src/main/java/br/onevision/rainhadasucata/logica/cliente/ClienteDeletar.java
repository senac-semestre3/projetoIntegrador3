/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ClienteDeletar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        Cliente cliente = new Cliente();
        cliente.setId(id);

        DaoCliente dao = new DaoCliente();
        dao.excluirCliente(cliente.getId());

        System.out.println("Excluindo contato... ");

        return "clientes.jsp";
    }

}
