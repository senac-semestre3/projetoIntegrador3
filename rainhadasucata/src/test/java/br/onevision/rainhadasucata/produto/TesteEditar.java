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
public class TesteEditar {
    public static void main(String[] args) {
        
    Produto produto = new Produto();
        
        produto.setNome("Óleo de Motor V8");
        produto.setMarca("Rainha da Sucata");
        produto.setDescricao("Rainha da Suacata. produto de qualidade");
        produto.setPrecoCompra(15.00);
        produto.setPrecoVenda(30.00);
        produto.setMargemVenda(100);
        produto.setEstoque(11);
        produto.setEstoqueMinimo(6);
        produto.setStatus(false);
        
        produto.setId(2);
        
        DaoProduto dao = new DaoProduto();
        dao.editarProduto(produto);
    }
}
