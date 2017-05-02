/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;
import java.sql.Date;

/**
 *
 * @author everton
 */
public class TesteEditar {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        
        usuario.setNome("Everton");
        usuario.setSobrenome("Roberto");
        usuario.setCpf("411.439.358-70");
        usuario.setSexo("M");
        usuario.setTelefone("(11) 5515-2677");
        usuario.setCelular("(11) 95166-9431");
        usuario.setEmail("everton_roliveira@outlook.com");
        usuario.setIdLoja(1);
        usuario.setNomeUsuario("everton.roliveira2");
        usuario.setSenha("P@ssw0rd");
        usuario.setStatus(false);
        usuario.setDataNascimento(Date.valueOf("1993-04-02"));
        usuario.setIdPermissao(1);
        
        usuario.setId(2);

        DaoUsuario dao = new DaoUsuario();
        dao.editarUsuario(usuario);
        
        
    }
}
