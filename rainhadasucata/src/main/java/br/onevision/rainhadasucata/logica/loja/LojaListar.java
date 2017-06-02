/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.loja;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Loja;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class LojaListar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Executando a logica ...");

        String busca = request.getParameter("busca");

        //cria lista de Clientes
        List<Loja> lojas;

        // Chama o daoCliente
        DaoLoja dao = new DaoLoja();

        if (busca == null || busca.equals("")) {
            System.out.println("Busca vazia");
            lojas = dao.listarTodos();
        } else {
            try {
                Long.parseLong(busca.replace(".", ""));
                lojas = dao.listaPorCnpj(busca);
                System.out.println("busca por cpf");
            } catch (Exception e) {
                lojas = dao.listaPorNome(busca);
                System.out.println("Busca por nome");
            }
        }
        // Guarda a lista no request
        request.setAttribute("lojas", lojas);

        System.out.println("Retornando o nome da página JSP ...");
        return "lojas.jsp";
    }
}
