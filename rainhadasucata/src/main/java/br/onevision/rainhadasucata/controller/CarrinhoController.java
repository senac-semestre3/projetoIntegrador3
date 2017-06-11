/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.controller;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Produto;
import br.onevision.rainhadasucata.model.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author everton
 */
public class CarrinhoController extends HttpServlet {

    List<ItemVenda> lista = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("itensVenda") == null) {
            
            lista.removeAll(lista);
            sessao.setAttribute("itensVenda", lista);
        }

        String destino = null;

        String acao = request.getParameter("acao");
        System.out.println(lista.size());

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Obteve o id da app  " + id);
            if (acao.equalsIgnoreCase("procurar")) {
                System.out.println("Vai procurar o produto");
                destino = procurarProduto(id);

            } else if (acao.equalsIgnoreCase("remover")) {
                System.out.println("Vai remover o produto da lista");
                destino = removeItem(id);

            } else {
                try {
                    int quantidade = Integer.parseInt(request.getParameter("quantidade"));

                    switch (acao) {
                        case "adicionar":
                            if (!existeNaLista(id)) {
                                System.out.println("Vai Adiciona produto");
                                destino = adicionarProduto(id, quantidade);
                            } else {
                                System.out.println("Ja existe na lista manda um erro");
                                JSONObject json = new JSONObject();
                                json.put("erro", "existe");
                                destino = json.toJSONString();
                            }
                            break;
                        case "aumentar":
                            System.out.println("vai aumentar");
                            destino = aumentaQuantidade(id, quantidade);
                            break;
                        case "diminuir":
                            System.out.println("Vai diminuir");
                            destino = diminuiQuantidade(id, quantidade);
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

        } catch (IOException | NumberFormatException e) {

            destino = "{\"id\" : -1}";// id invalido
        }
        Venda venda;
        venda = (Venda) sessao.getAttribute("venda");
        lista = (List<ItemVenda>) sessao.getAttribute("itensVenda");
        venda.setItens(lista);
        venda.calculaTotal();
        System.out.println("Total " + venda.getTotal());

        //mando para a aplicao
        PrintWriter out = response.getWriter();
        out.println(destino);
    }

// procura produto
    private String procurarProduto(int id) throws IOException {

        try {
            Produto produto;
            DaoProduto dao = new DaoProduto();
            produto = dao.obter(id);
            return produto.toJSON().toJSONString();
        } catch (Exception ex) {
            // se não for possivel obter o produto retorno zero 
            // e trato no javascript
            JSONObject json = new JSONObject();
            return json.put("id", "0").toString();
        }
    }

    // aumenta quantidade
    private String aumentaQuantidade(int id, int quantidade) {
        JSONObject json = new JSONObject();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getProduto().getId() == id) {

                if (quantidade <= lista.get(i).getProduto().getEstoque()) {
                    lista.get(i).setQuantidade(quantidade);
                    lista.get(i).calculaSubtotal();

                    json.put("subtotal", lista.get(i).getSubtotal());

                    return json.toJSONString();
                } else {
                    // se não for possivel aumentar quantidade no produto retorno erro 
                    // e trato no javascript
                    json.put("erro", "quantidadeExcede");
                    json.put("estoque", lista.get(i).getProduto().getEstoque());
                    lista.get(i).setQuantidade(lista.get(i).getProduto().getEstoque());
                    lista.get(i).calculaSubtotal();
                    json.put("subtotal", lista.get(i).getSubtotal());
                    return json.toJSONString();
                }
            }
        }
        return null;
    }

    // diminui quantidade
    private String diminuiQuantidade(int id, int quantidade) {
        JSONObject json = new JSONObject();
        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getProduto().getId() == id) {
                if (quantidade >= 1) {
                    lista.get(i).setQuantidade(quantidade);
                    lista.get(i).calculaSubtotal();
                    System.out.println("Subtotal = " + lista.get(i).getSubtotal());
                    json.put("subtotal", lista.get(i).getSubtotal());
                    return json.toJSONString();
                } else {
                    json.put("erro", "quantidadeInvalida");
                    return json.toJSONString();
                }
            }
        }
        return null;
    }

    private String adicionarProduto(int id, int quantidade) {
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
            produto = dao.obter(id);
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            item.calculaSubtotal();
            System.out.println("Tamanho antes " + lista.size());
            lista.add(item);

            System.out.println("Tamanho depois " + lista.size());
            return item.toJSON().toJSONString();

        } catch (Exception ex) {

            // se não for possivel obter o produto retorno erro 
            // e trato no javascript
            JSONObject json = new JSONObject();
            json.put("erro", "obter");
            return json.toJSONString();
        }
    }

    private boolean existeNaLista(int id) {
        System.out.println("Esta no metodo de verificação");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("id da app = " + id);
            System.out.println("id da lista = " + lista.get(i).getProduto().getId());
            if (lista.get(i).getProduto().getId() == id) {
                System.out.println("id igual");
                return true;
            }
        }
        return false;
    }

    private String removeItem(int id) {
        JSONObject json = new JSONObject();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Id do app" + id);
            System.out.println("Id da lista" + lista.get(i).getProduto().getId());
            if (lista.get(i).getProduto().getId() == id) {
                System.out.println("Id igual");
                lista.remove(i);
                json.put("msg", "removido");
                return json.toJSONString();

            }
        }
        return json.put("msg", "erro").toString();
    }
}
