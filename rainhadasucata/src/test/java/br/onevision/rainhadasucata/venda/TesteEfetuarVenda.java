/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.venda;

import br.onevision.rainhadasucata.dao.ClienteDao;
import br.onevision.rainhadasucata.dao.ItemVendaDao;
import br.onevision.rainhadasucata.dao.ProdutoDao;
import br.onevision.rainhadasucata.dao.UsuarioDao;
import br.onevision.rainhadasucata.dao.VendaDao;
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
public class TesteEfetuarVenda {
    public static void main(String[] args) throws Exception {
        
        //----------Passo 1 obtenho o cliente----------
        
        Cliente cliente;
        ClienteDao clienteDao = new ClienteDao();
        
        int idCli = 2;// id a ser buscado
        cliente = clienteDao.obter(idCli);
        
        System.out.println("Id cliente: " + cliente.getId());
        System.out.println("");
        
        //---------Passo 2 obtenho Usuario-------------
        
        Usuario usuario;
        UsuarioDao usuarioDao = new UsuarioDao();
        
        int idUser = 3;
        usuario = usuarioDao.obter(idUser);
        System.out.println("Id Usuario: " + usuario.getId());
        System.out.println("");
        
        
        //--------Passo 3 seto a venda ----------------

        Venda venda = new Venda();

        venda.setMetodoPagamento("Dinheiro");
        venda.setDesconto(10);
        venda.setCliente(cliente);
        venda.setUsuario(usuario);

        
        //---------Passo 4 obter os produtos-----------

        Produto pro1;
        Produto pro2;
        Produto pro3;
        ProdutoDao produtoDao = new ProdutoDao();
        
        int idProduto = 1;// id do produto a ser obtido 
        
        // incrementa o id em 1 em cada produto
        pro1 = produtoDao.obter(idProduto);
        pro2 = produtoDao.obter(idProduto++);
        pro3 = produtoDao.obter(idProduto++);
        
        //--------Passo 5 Cria a lista de produtos--------
        
        ItemVenda item1 = new ItemVenda();
        ItemVenda item2 = new ItemVenda();
        ItemVenda item3 = new ItemVenda();
        List<ItemVenda> itensVenda = new ArrayList<>();
        
        item1.setQuantidade(2);
        item1.setProduto(pro1);
        
        System.out.println("Id Pro1: " + item1.getProduto().getId());
        System.out.println("");

        item2.setQuantidade(1);
        item2.setProduto(pro2);
        
        System.out.println("Id Pro2: " + item2.getProduto().getId());
        System.out.println("");
        
        item3.setQuantidade(1);
        item3.setProduto(pro3);
        
        System.out.println("Id Pro3: " + item3.getProduto().getId());
        System.out.println("");
        
        itensVenda.add(item1);
        itensVenda.add(item2);
        itensVenda.add(item3);
        
        venda.setItens(itensVenda);
        
        VendaDao vendaDao = new VendaDao();

        //vendaDao.inserir(venda);
        
        int ultimaVenda = vendaDao.obterUltimoIdDeVenda();
        System.out.println("Id Ultima Venda: " + ultimaVenda);
        
        ItemVendaDao itemDao = new ItemVendaDao();
        itemDao.inserir(venda.getItens(), ultimaVenda);
  
    }
}
