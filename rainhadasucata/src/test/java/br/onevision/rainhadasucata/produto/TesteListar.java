/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.produto;

import br.onevision.rainhadasucata.dao.ProdutoDao;
import br.onevision.rainhadasucata.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteListar {

    public static void main(String[] args) throws Exception {

        Produto produto;
        ProdutoDao dao = new ProdutoDao();

        List<Produto> produtos = new ArrayList<>();
        
        //listar por nome
        String nome = "";
        //listar por marca
        String marca = "";
        //listar por status
        Boolean status = null;
        //lista por quantidade
        Integer quantidade = null;
        

        //produtos = dao.listaPorNome(nome);// Chamada da dao listarPorNome
        //produtos = dao.listaPorMarca(marca);// Chamada da dao listarPorNome
        //produtos = dao.listaPorQuantidade(quantidade);// Chamada da dao listarPorQuantidade
        //produtos = dao.listaPorStatus(status);// Chamada da dao listarPorStatus
        //produtos = dao.listarTodos();// Chamada da dao listarTodos
        produtos = dao.listaCustomizada(nome, marca, quantidade, status);

        for (Produto pro : produtos) {
        System.out.println("ID Produto: " + pro.getId());
        System.out.println("Nome: " + pro.getNome());
        System.out.println("Marca: " + pro.getMarca());
        System.out.println("Descrição: " + pro.getDescricao());
        System.out.println("Preço Compra: " + pro.getPrecoCompra());
        System.out.println("Preço Venda: " + pro.getPrecoVenda());
        System.out.println("Margem: " + pro.getMargemVenda());
        System.out.println("Estoque: " + pro.getEstoque());
        System.out.println("Estoque Mínimo: " + pro.getEstoqueMinimo());
        System.out.println("Status: " + pro.isStatus());

        System.out.println("**************************************");
            System.out.println("");
        }
    }
}
