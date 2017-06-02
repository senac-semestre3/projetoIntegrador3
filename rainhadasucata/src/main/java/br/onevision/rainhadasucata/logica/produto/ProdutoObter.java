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
public class ProdutoObter implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        System.out.println("Executando a logica ...");

        int id = Integer.parseInt(request.getParameter("id"));
        
        String pagina = request.getParameter("pagina");
        
        Produto produto;     
        DaoProduto dao = new DaoProduto();
        produto = dao.obter(id);
        

        request.setAttribute("produto", produto);
        
        System.out.println("Retornando o nome da página JSP ...");
        
        if (pagina.equals("produto-editar")) {
            return "produto-editar.jsp";
        }else{
            return "produto-ver.jsp";
        }
    }
    
}
