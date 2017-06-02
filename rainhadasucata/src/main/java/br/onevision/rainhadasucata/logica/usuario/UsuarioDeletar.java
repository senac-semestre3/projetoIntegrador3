/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class UsuarioDeletar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario usuario = new Usuario();
        usuario.setId(id);

        DaoUsuario dao = new DaoUsuario();
        dao.excluir(usuario.getId());

        System.out.println("Excluindo usuario... ");

        return "usuarios.jsp";
    }

}
