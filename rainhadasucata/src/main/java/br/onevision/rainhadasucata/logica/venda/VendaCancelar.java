/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.venda;

import br.onevision.rainhadasucata.logica.Logica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author everton
 */
public class VendaCancelar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        HttpSession sessao = request.getSession();
        sessao.removeAttribute("itensVenda");
        sessao.removeAttribute("venda");
        
        return "clientes.jsp";
    }
}
