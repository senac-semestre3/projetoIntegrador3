/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.produto;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Produto;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ProdutoEditar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Produto produto = new Produto();

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String descricao = request.getParameter("descricao");
        String precoCompra = request.getParameter("valor-compra");
        String margem = request.getParameter("margem-lucro");
        String precoVenda = request.getParameter("valor-venda");
        String estoque = request.getParameter("estoque");
        String estoqueMin = request.getParameter("estoque-minimo");
        
        try {
            String status = request.getParameter("status");
            if (status.equalsIgnoreCase("on")) {
                produto.setStatus(1);
            } else {
                produto.setStatus(0);
            }
        } catch (Exception e) {
            produto.setStatus(0);
        }


        produto.setNome(nome);
        produto.setMarca(marca);
        produto.setDescricao(descricao);
        
        try {
            produto.setId(Integer.parseInt(id));
        } catch (Exception e) {
            return "produto-editar.jsp";
        }

        try {
            produto.setPrecoCompra(Double.parseDouble(precoCompra));
            produto.setMargemVenda(Double.parseDouble(margem));
            produto.setPrecoVenda(Double.parseDouble(precoVenda));
            
            produto.setEstoque(Integer.parseInt(estoque));
            produto.setEstoqueMinimo(Integer.parseInt(estoqueMin));
        } catch (Exception e) {
            return "produto-editar.jsp";
        }

        if (produtoValida(produto)) {
            DaoProduto dao = new DaoProduto();
            dao.editar(produto);
        }

        return "produtos.jsp";
    }

    public boolean produtoValida(Produto produto) {
        if (produto == null) {
            return false;
        }
        if (produto.getId() <= 0) {
            System.out.println("Id com erro");
            return false;
        }
        if (produto.getNome() == null || produto.getNome().equals("")) {
            System.out.println("Nome com erro");
            return false;
        }

        if (produto.getNome() == null || produto.getNome().equals("")) {
            return false;
        }
        return produto.getPrecoVenda() >= 0;
    }
}
