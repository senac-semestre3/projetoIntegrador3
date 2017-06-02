/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.loja;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Conversao;
import br.onevision.rainhadasucata.model.Loja;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class LojaObter implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        System.out.println("Executando a logica ...");

        int id = Integer.parseInt(request.getParameter("id"));
        
        String pagina = request.getParameter("pagina");
        
        Loja loja;     
        DaoLoja dao = new DaoLoja();
        loja = dao.obter(id);
        

        request.setAttribute("loja", loja);
        
        System.out.println("Retornando o nome da página JSP ...");
        
        if (pagina.equals("loja-editar")) {
            return "loja-editar.jsp";
        }else{
            return "loja-ver.jsp";
        }
    }
    
}
