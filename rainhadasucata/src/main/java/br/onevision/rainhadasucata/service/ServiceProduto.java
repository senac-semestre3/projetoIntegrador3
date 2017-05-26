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

    public boolean buscarProduto(Produto produto) throws RuntimeException, SQLException, Exception {

        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.obter(hashCode());

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listarAll(Produto produto) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listarTodos();

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listaNome(Produto produto, String nome) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listaPorNome(nome);

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listaProduto(Produto produto, String marca) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listaPorMarca(marca);

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listaQuantidade(Produto produto) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listaPorQuantidade(Integer.MIN_VALUE);

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listaStatus(Produto produto) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listaPorStatus(Boolean.TRUE);

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }

    public boolean listaCustom(Produto produto, String nome, String marca) throws SQLException, Exception {
        try {
            DaoProduto daoProduto = new DaoProduto();

            daoProduto.listaCustomizada(nome, marca, Integer.MIN_VALUE, Boolean.TRUE);

            return true;

        } catch (RuntimeException | SQLException e) {
            return false;
        }

    }
}
//}
