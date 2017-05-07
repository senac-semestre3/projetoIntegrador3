/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.produto;

import br.onevision.rainhadasucata.dao.ProdutoDao;
import br.onevision.rainhadasucata.model.Produto;

/**
 *
 * @author everton
 */
public class TesteInserir {
    public static void main(String[] args) throws RuntimeException, Exception {
        
        Produto produto = new Produto();
        
        produto.setNome("Óleo de Motor");
        produto.setMarca("Rainha do Óleo");
        produto.setDescricao("Rainha do Óleo. produto de qualidade");
        produto.setPrecoCompra(10.00);
        produto.setPrecoVenda(20.00);
        produto.setMargemVenda(50);
        produto.setEstoque(10);
        produto.setEstoqueMinimo(5);
        produto.setStatus(true);
        
        ProdutoDao dao = new ProdutoDao();
        dao.inserir(produto);
    }
}