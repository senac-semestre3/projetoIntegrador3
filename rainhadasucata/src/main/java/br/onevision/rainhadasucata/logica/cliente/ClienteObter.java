/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Conversao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ClienteObter implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        System.out.println("Executando a logica ...");
        
        Conversao converte = new Conversao();
        int id = Integer.parseInt(request.getParameter("id"));
        
        String pagina = request.getParameter("pagina");
        
        Cliente cliente;     
        DaoCliente dao = new DaoCliente();
        cliente = dao.obter(id);
        
        cliente.setDataNascimento(converte.converteDataNormal(cliente.getDataNascimento()));
        
        if (cliente.getSexo().equalsIgnoreCase("M")) {
            cliente.setSexo("Masculino");
        }else if(cliente.getSexo().equalsIgnoreCase("F")){
            cliente.setSexo("Feminino");
        }
        request.setAttribute("cliente", cliente);
        
        System.out.println("Retornando o nome da página JSP ...");
        
        if (pagina.equals("cliente-editar")) {
            return "cliente-editar.jsp";
        }else if(pagina.equals("cliente-ver")){
            return "cliente-ver.jsp";
        }else{
            return "vendas.jsp";
        }
    }
    
}
