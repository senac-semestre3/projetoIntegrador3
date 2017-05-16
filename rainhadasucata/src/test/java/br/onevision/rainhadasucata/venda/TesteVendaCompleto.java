/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.venda;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.dao.DaoItemVenda;
import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.dao.DaoVenda;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Produto;
import br.onevision.rainhadasucata.model.Usuario;
import br.onevision.rainhadasucata.model.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteVendaCompleto {
    public static void main(String[] args) throws Exception {
        
        //----------Passo 1 obtenho o cliente----------
        
        Cliente cliente;
        DaoCliente clienteDao = new DaoCliente();
        
        int idCli = 3;// id a ser buscado
        cliente = clienteDao.obter(idCli);

        
        //---------Passo 2 obtenho Usuario-------------
        
        Usuario usuario;
        DaoUsuario usuarioDao = new DaoUsuario();
        
        int idUser = 3;
        usuario = usuarioDao.obter(idUser);
        
        
        //--------Passo 3 seto a venda ----------------

        Venda venda = new Venda();

        venda.setMetodoPagamento("Dinheiro");
        venda.setDesconto(15);
        venda.setCliente(cliente);
        venda.setUsuario(usuario);

        
        //---------Passo 4 obter os produtos-----------

        Produto pro1;
        Produto pro2;
        Produto pro3;
        DaoProduto produtoDao = new DaoProduto();
        
        int idProduto = 1;// id do produto a ser obtido 
        
        // incrementa o id em 1 em cada produto
        pro1 = produtoDao.obter(idProduto);
        pro2 = produtoDao.obter(++idProduto);
        pro3 = produtoDao.obter(++idProduto);
        
        //--------Passo 5 Cria a lista de produtos--------
        
        ItemVenda item1 = new ItemVenda();
        ItemVenda item2 = new ItemVenda();
        ItemVenda item3 = new ItemVenda();
        List<ItemVenda> itensVenda = new ArrayList<>();
        
        item1.setQuantidade(2);
        item1.setProduto(pro1);

        item2.setQuantidade(1);
        item2.setProduto(pro2);
        
        item3.setQuantidade(1);
        item3.setProduto(pro3);
        
        itensVenda.add(item1);
        itensVenda.add(item2);
        itensVenda.add(item3);
        
        venda.setItens(itensVenda);
        
        System.out.println("**************************");
        System.out.println("     DADOS DA COMPRA");
        System.out.println("**************************");
        System.out.println("");
        System.out.println("Cliente: " + venda.getCliente().getNome());
        System.out.println("");
        System.out.println("Vendedor: " + venda.getUsuario().getNome());
        System.out.println("");
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
        System.out.println("");
        System.out.println("**************************");
        System.out.println("TOTAL: " + venda.calculaTotal());
        System.out.println("**************************");
        
        DaoVenda vendaDao = new DaoVenda();

        vendaDao.inserir(venda);
        
        int ultimaVenda = vendaDao.obterUltimoIdDeVenda();
        System.out.println("Id Ultima Venda: " + ultimaVenda);
        
        DaoItemVenda itemDao = new DaoItemVenda();
        itemDao.inserir(venda.getItens(), ultimaVenda);
  
    }
}
