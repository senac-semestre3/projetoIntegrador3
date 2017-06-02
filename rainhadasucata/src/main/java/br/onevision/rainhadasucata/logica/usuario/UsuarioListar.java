/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class UsuarioListar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Executando a logica ...");

        String busca = request.getParameter("busca");

        //cria lista de Clientes
        List<Usuario> usuarios;

        // Chama o daoCliente
        DaoUsuario dao = new DaoUsuario();

        if (busca == null || busca.equals("")) {
            System.out.println("Busca vazia");
            usuarios = dao.listarTodos();
        } else {

            try {
                Long.parseLong(busca.replace(".", ""));
                usuarios = dao.listaPorCpf(busca);
                System.out.println("busca por cpf");
            } catch (Exception e) {
                usuarios = dao.listaPorNome(busca);
                System.out.println("Busca por nome");
            }
        }
        // Guarda a lista no request
        request.setAttribute("usuarios", usuarios);

        System.out.println("Retornando o nome da pagina JSP ...");
        return "usuarios.jsp";
    }
}
