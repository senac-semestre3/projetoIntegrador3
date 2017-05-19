/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.service;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Produto;
import java.sql.SQLException;

/**
 *
 * @author DANILO&PAULA
 */
public class ServiceProduto {

    public ServiceProduto() {
    }

    public boolean inserirProduto(Produto produto) throws RuntimeException, SQLException {

        if (produto == null) {
            return false;
        }
        if (produto.getNome() == null || produto.getNome().equals("")) {
            return false;
        }
        if (produto.getPrecoVenda() < 0) {
            return false;
        }

        try {
            DaoProduto dao = new DaoProduto();

            dao.inserir(produto);
            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }
}
//}
