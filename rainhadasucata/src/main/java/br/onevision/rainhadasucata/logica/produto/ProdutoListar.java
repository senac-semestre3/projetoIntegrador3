/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.produto;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ProdutoListar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Executando a logica ...");

        //cria lista de Produtos
        List<Produto> produtos = new ArrayList<>();

        // Chama o daoProduto
        DaoProduto dao = new DaoProduto();

        // Verifico se existe os parametros passados pelo request
        // se não existir parametro algum quer dizer que a pagina foi chamada pelo menu
        // entao ele retorna todos os produtos
        try {
            String buscaId = request.getParameter("buscaId");
            String buscaNome = request.getParameter("buscaNome");
            String buscaPrecoVenda = request.getParameter("buscaPrecoVenda");
            String buscaEstoque = request.getParameter("buscaEstoque");
            String buscaStatus = request.getParameter("buscaStatus");

            String[] parans
                    = {buscaId, buscaNome, buscaPrecoVenda, buscaEstoque, buscaStatus};

            // conta quantos parametros estão preenchidos
            int cont = 0;

            for (int i = 0; i < parans.length; i++) {

                if (!parans[i].equals("")) {
                    cont++;
                }
            }
            System.out.println("cont = " + cont);
            // se todos os parametros forem vazio ou nulo retorna todos os produtos
            if (cont == 0) {
                System.out.println("Busca vazia");
                produtos = dao.listarTodos();

            } // se o id for preenchido ele chama o método obter já que não existe
            // mais de 1 produto com o mesmo id
            else if (!buscaId.equals("")) {
                
                Produto produto;
                produto = dao.obter(Integer.parseInt(buscaId));
                produtos.add(produto);

                // aqui ele irá customizar a busca 
            } else if (cont == 1 && buscaId.equals("")) {

                if (!buscaNome.equals("")) {

                    produtos = dao.listaPorNome(buscaNome);

                } else if (!buscaPrecoVenda.equals("")) {

                    produtos = dao.listaPorPrecoVenda(buscaPrecoVenda);

                } else if (!buscaEstoque.equals("")) {

                    produtos = dao.listaPorQuantidade(Integer.parseInt(buscaEstoque));

                } else if (!buscaStatus.equals("")) {
                    boolean status = buscaStatus.equals("on");
                    produtos = dao.listaPorStatus(status);
                }
            } else {
                boolean status;
                status = buscaStatus.equals("on");
                produtos = dao.listaCustomizada(buscaNome, buscaPrecoVenda,
                        Integer.parseInt(buscaEstoque), status);
            }

        } catch (Exception e) {

            // se não existir parametro algum retorna todos os produtos
            produtos = dao.listarTodos();

        }

        request.setAttribute("produtos", produtos);
        System.out.println("Retornando o nome da página JSP ...");
        return "produtos.jsp";

    }
}
