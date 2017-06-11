/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Conversao;
import br.onevision.rainhadasucata.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class UsuarioObter implements Logica{

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) 
            throws Exception {
        
        System.out.println("Executando a logica ...");
        
        Conversao converte = new Conversao();
        int id = Integer.parseInt(request.getParameter("id"));
        
        String pagina = request.getParameter("pagina");
        
        Usuario usuario;     
        DaoUsuario dao = new DaoUsuario();
        usuario = dao.obter(id);
        
        try {
            usuario.setDataNascimento(converte.converteDataNormal(usuario.getDataNascimento()));
        } catch (Exception e) {
            usuario.setDataNascimento("");
        }
        
        if (usuario.getSexo().equalsIgnoreCase("M")) {
            usuario.setSexo("Masculino");
        }else if(usuario.getSexo().equalsIgnoreCase("F")){
            usuario.setSexo("Feminino");
        }

        request.setAttribute("usuario", usuario);
        
        System.out.println("Retornando o nome da pagina JSP ...");
        
        if (pagina.equals("usuario-editar")) {
            return "usuario-editar.jsp";
        }else{
            return "usuario-ver.jsp";
        }
    }
    
}
