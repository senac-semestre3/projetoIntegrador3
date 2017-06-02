/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.produto;

import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Loja;
import br.onevision.rainhadasucata.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ProdutoDeletar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        Produto produto = new Produto();
        produto.setId(id);

        DaoProduto dao = new DaoProduto();
        dao.excluir(produto.getId());

        System.out.println("Excluindo produto... ");

        return "produtos.jsp";
    }

}
