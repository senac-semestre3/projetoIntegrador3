/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.venda;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class VendaSetaCliente implements Logica{
    
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        System.out.println("Executando a logica ...");
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        String pagina = request.getParameter("pagina");
        
        Cliente cliente;     
        DaoCliente dao = new DaoCliente();
        cliente = dao.obter(id);

        request.setAttribute("cliente", cliente);
        
        System.out.println("Retornando o nome da pagina JSP ...");
        
        if (pagina.equals("usuario-editar")) {
            return "usuario-editar.jsp";
        }else{
            return "usuario-ver.jsp";
        }
    }
}
