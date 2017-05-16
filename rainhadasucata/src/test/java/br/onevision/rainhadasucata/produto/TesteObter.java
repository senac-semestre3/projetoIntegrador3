/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.produto;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Produto;

/**
 *
 * @author everton
 */
public class TesteObter {

    public static void main(String[] args) throws Exception {
        Produto produto;
        DaoProduto dao = new DaoProduto();

        int id = 2;// id a ser buscado

        produto = dao.obter(id);

        System.out.println("ID Produto: " + produto.getId());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Marca: " + produto.getMarca());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Preço Compra: " + produto.getPrecoCompra());
        System.out.println("Preço Venda: " + produto.getPrecoVenda());
        System.out.println("Margem: " + produto.getMargemVenda());
        System.out.println("Estoque: " + produto.getEstoque());
        System.out.println("Estoque Mínimo: " + produto.getEstoqueMinimo());
        System.out.println("Status: " + produto.isStatus());

        System.out.println("**************************************");

    }
}
