/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.controller;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;

/**
 *
 * @author everton
 */
public class CarrinhoController extends HttpServlet {

    // lista de itens de venda
    private List<ItemVenda> lista = new ArrayList<>();

    // id mandado pela aplicação
    private int idProduto;
    private int quantidadeProduto;

    // se todo processo ocorrer bem esse destino será um produto 
    // para a aplicação
    private String destino;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String acao = request.getParameter("acao");
        System.out.println("Ação " + acao);
        try {
            idProduto = Integer.parseInt(request.getParameter("id"));
            System.out.println("Obteve o id da app  " + idProduto);
            if (acao.equalsIgnoreCase("procurar")) {
                System.out.println("Vai procurar o produto");
                procurarProduto();

            } else if (acao.equalsIgnoreCase("remover")) {
                System.out.println("Vai remover o produto da lista");
                removeItem();

            } else {

                try {
                    quantidadeProduto = Integer.parseInt(request.getParameter("quantidade"));

                    switch (acao) {
                        case "adicionar":
                            if (!existeNaLista()) {
                                System.out.println("Vai Adiciona produto");
                                adicionarProduto();
                            } else {
                                System.out.println("Ja existe na lista manda um erro");
                                JSONObject json = new JSONObject();
                                json.put("erro", "existe");
                                destino = json.toJSONString();
                            }
                            break;
                        case "aumentar":
                            System.out.println("vai aumentar");
                            aumentaQuantidade();
                            break;
                        case "diminuir":
                            System.out.println("Vai diminuir");
                            diminuiQuantidade();
                            break;
                        default:
                            break;
                    }

                } catch (Exception e) {
                    JSONObject json = new JSONObject();
                    json.put("erro", "quantidadeInvalida");
                    destino = json.toJSONString();
                }
            }

        } catch (Exception e) {

            destino = "{\"id\" : -1}";// id invalido
        }

        //mando para a aplicação
        PrintWriter out = response.getWriter();
        out.println(destino);
    }

    private void procurarProduto() throws IOException {

        try {
            Produto produto;
            DaoProduto dao = new DaoProduto();
            produto = dao.obter(idProduto);
            destino = produto.toJSON().toJSONString();
            System.out.println("Obteve o produto");
        } catch (Exception ex) {
            // se não for possivel obter o produto retorno zero 
            // e trato no javascript
            destino = "{\"id\" : 0}";
        }

    }

    private void aumentaQuantidade() {
        JSONObject json = new JSONObject();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getProduto().getId() == idProduto) {
                if (quantidadeProduto <= lista.get(i).getProduto().getEstoque()) {
                    lista.get(i).setQuantidade(quantidadeProduto);
                    lista.get(i).calculaSubtotal();
                    json.put("subtotal", lista.get(i).getSubtotal());
                    destino = json.toJSONString();
                } else {
                    // se não for possivel aumentar quantidade no produto retorno erro 
                    // e trato no javascript
                    json.put("erro", "quantidadeExcede");
                    destino = json.toJSONString();
                }
            }
        }
    }

    private void diminuiQuantidade() {
        JSONObject json = new JSONObject();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getProduto().getId() == idProduto) {
                if (quantidadeProduto >= 1) {
                    lista.get(i).setQuantidade(quantidadeProduto);
                    lista.get(i).calculaSubtotal();
                    System.out.println("Subtotal = " + lista.get(i).getSubtotal());
                    json.put("subtotal", lista.get(i).getSubtotal());
                    destino = json.toJSONString();
                } else {
                    json.put("erro", "quantidadeInvalida");
                    destino = json.toJSONString();
                }
            }
        }
    }

    private void adicionarProduto() {
        try {

            // se não der erro ao obter o produto
            // Faço uma instancia de ItemVenda
            // seto o produto no item de venda
            // seto quantidade que está vindo da aplicação
            // calculo o subtotal
            // adiciono o item de venda na lista
            Produto produto;
            ItemVenda item = new ItemVenda();
            DaoProduto dao = new DaoProduto();
            produto = dao.obter(idProduto);
            item.setProduto(produto);
            item.setQuantidade(quantidadeProduto);
            item.calculaSubtotal();
            lista.add(item);
            destino = item.toJSON().toJSONString();

        } catch (Exception ex) {

            // se não for possivel obter o produto retorno erro 
            // e trato no javascript
            JSONObject json = new JSONObject();
            json.put("erro", "obter");
            destino = json.toJSONString();
        }
    }

    private boolean existeNaLista() {
        System.out.println("Esta no método de verificação");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("id da app = " + idProduto);
            System.out.println("id da lista = " + lista.get(i).getProduto().getId());
            if (lista.get(i).getProduto().getId() == idProduto) {
                System.out.println("id igual");
                return true;
            }
        }
        return false;
    }

    private void removeItem() {
        JSONObject json = new JSONObject();
        System.out.println("Esta dentro do remover");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Id do app" + idProduto);
            System.out.println("Id da lista" + lista.get(i).getProduto().getId());
            if (lista.get(i).getProduto().getId() == idProduto) {
                System.out.println("Id igual");
                lista.remove(i);
                 json.put("msg", "removido");
                System.out.println("Removido");
            } else {  
                json.put("msg", "erro");
                
            }
        }
        destino = json.toJSONString();
    }
}
