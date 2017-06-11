/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.venda;

import br.onevision.rainhadasucata.dao.DaoItemVenda;
import br.onevision.rainhadasucata.dao.DaoVenda;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Venda;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author everton
 */
public class VendaFaturar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession sessao = request.getSession();
        String pagamento = request.getParameter("metodoPagamento");

        if (sessao.getAttribute("sessionusuario") != null) {

            if (sessao.getAttribute("venda") != null) {
                if (sessao.getAttribute("itensVenda") != null) {
                    List<ItemVenda> lista = new ArrayList<>();
                    lista = (List<ItemVenda>) sessao.getAttribute("itensVenda");

                    Venda venda = (Venda) sessao.getAttribute("venda");

                    venda.setMetodoPagamento(pagamento);
                    System.out.println("Pagamento " + venda.getMetodoPagamento());
                    System.out.println("id do cliente " + venda.getCliente().getId());
                    System.out.println("id do usuario " + venda.getUsuario().getId());
                    System.out.println("nome do usuario " + venda.getUsuario().getNome());
                    System.out.println("valor da venda " + venda.getTotal());

                    DaoVenda daoVenda = new DaoVenda();

                    daoVenda.inserir(venda);
                    Integer id = daoVenda.obterUltimoIdDeVenda();

                    DaoItemVenda daoItem = new DaoItemVenda();
                    daoItem.inserir(lista, id);
                    System.out.println("vendeu");

                    sessao.removeAttribute("itensVenda");
                    sessao.removeAttribute("venda");

                    return "clientes.jsp";
                } else {
                    sessao.removeAttribute("itensVenda");
                    return "vendas.jsp";
                }

            } else {
                sessao.removeAttribute("itensVenda");
                sessao.removeAttribute("venda");

                return "clientes.jsp";
            }
        } else {
            sessao.invalidate();
            //trocar para request getdispacher
            response.sendRedirect("login.jsp");
        }
        
        return "login.jsp";
    }

}
