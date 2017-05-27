/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.service;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Produto;
import java.sql.SQLException;
import java.util.List;

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
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.inserir(produto);
            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean editarProduto(Produto produto) throws RuntimeException, SQLException {

        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.editarProduto(produto);
            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public List<Produto> listarTodos() throws RuntimeException, SQLException, Exception {

        try {
            DaoProduto dao = new DaoProduto();

            return dao.listarTodos();

        } catch (RuntimeException | SQLException e) {
            return null;
        }
    }

    public Produto obter(int id) throws SQLException, Exception {
        try {
            DaoProduto dao = new DaoProduto();

            return dao.obter(id);

        } catch (RuntimeException | SQLException e) {
            return null;
        }
    }

    public List<Produto> listarPoNome(String nome) throws SQLException, Exception {
        try {
            DaoProduto dao = new DaoProduto();

            return dao.listaPorNome(nome);
            
        } catch (RuntimeException | SQLException e) {
            return null;
        }

    }

}
//}
