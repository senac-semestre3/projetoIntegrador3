/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.venda;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Conversao;
import br.onevision.rainhadasucata.model.Data;
import br.onevision.rainhadasucata.model.Usuario;
import br.onevision.rainhadasucata.model.Venda;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author everton
 */
public class VendaCliente implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String id = request.getParameter("id");

        try {
            //cria um novo cliente
            //obtem o cliente com o id passado
            Cliente cliente;
            DaoCliente dao = new DaoCliente();
            cliente = dao.obter(Integer.parseInt(id));
            
            // setei cliente na sessao
            Venda venda = new Venda();
            venda.setCliente(cliente);
            
            // setando a data no formato da aplicação
            Conversao converte = new Conversao();
            Data data= new Data();
            venda.setData(converte.converteDataNormal(data.getDataAtual()));
            
            // criei um novo usuario
            Usuario usuario;
            
            HttpSession sessao = request.getSession();
             
            // resgatei o usario ativo na sessao
            usuario = (Usuario) sessao.getAttribute("sessionusuario");

            // setei usuario na venda
            venda.setUsuario(usuario);
            
            //setei venda na sessao
            sessao.setAttribute("venda", venda);
            
        } catch (Exception e) {
            //
        }

        return "vendas.jsp";
    }

}
