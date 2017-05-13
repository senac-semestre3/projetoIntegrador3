/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.venda;

import br.onevision.rainhadasucata.dao.ItemVendaDao;
import br.onevision.rainhadasucata.dao.ProdutoDao;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteItemVendaUnitario {
    public static void main(String[] args) throws Exception {
        
        //---------Passo 1 obter os produtos-----------

        Produto pro1;
        Produto pro2;
        Produto pro3;
        ProdutoDao produtoDao = new ProdutoDao();
        
        int idProduto = 1;// id do produto a ser obtido 
        
        // incrementa o id em 1 em cada produto
        pro1 = produtoDao.obter(idProduto);
        pro2 = produtoDao.obter(++idProduto);
        pro3 = produtoDao.obter(++idProduto);
        
        //--------Passo 2 Cria a lista de produtos--------
        
        ItemVenda item1 = new ItemVenda();
        ItemVenda item2 = new ItemVenda();
        ItemVenda item3 = new ItemVenda();
        List<ItemVenda> itensVenda = new ArrayList<>();
        
        item1.setQuantidade(1);
        item1.setProduto(pro1);

        item2.setQuantidade(2);
        item2.setProduto(pro2);
        
        item3.setQuantidade(1);
        item3.setProduto(pro3);
        
        itensVenda.add(item1);
        itensVenda.add(item2);
        itensVenda.add(item3);

        System.out.println("Carrinho******************");
        System.out.println("");
        for (ItemVenda itens: itensVenda) {
            System.out.println("Id Produto: " + itens.getProduto().getId());
            System.out.println("Produto: " + itens.getProduto().getNome());
            System.out.println("Valor Uni: " + itens.getProduto().getPrecoVenda());
            System.out.println("Quantidade: " + itens.getQuantidade());
            System.out.println("Subtotal: " + itens.calculaSubtotal());
            System.out.println("");
        }
        
        int ultimaVenda = 3;
        ItemVendaDao itemDao = new ItemVendaDao();
        itemDao.inserir(itensVenda, ultimaVenda);
  
    }
}
