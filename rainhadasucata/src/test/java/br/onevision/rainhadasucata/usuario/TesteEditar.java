/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author everton
 */


public class TesteEditar {
    public static void main(String[] args) throws SQLException {
        Usuario usuario = new Usuario();
        
        usuario.setNome("Ricardo");
        usuario.setCpf("391.123.258-60");
        usuario.setDataNascimento("11 May, 2017"); // insere data teste
        usuario.setSexo("M");
        usuario.setTelefone("(11)5515-0010");
        usuario.setCelular("(11)95166-0011");
        usuario.setEmail("bah_amaral@outlook.com.br");
        usuario.setCep("00000055");
        usuario.setLogradouro("Rua Hélio Jacy Ricardo");
        usuario.setNumero("36");
        usuario.setBairro("Jardim Francisco aaaa");
        usuario.setCidade("Araçariguama aaaaa");
        usuario.setEstado("RY");
        usuario.setComplemento("Casa 25");
        usuario.setNomeUsuario("bah.amaralhhhh");
        usuario.setSenha("BahAmaralhhh");
        usuario.setStatus(1);
        usuario.setIdPermissao(1);
        usuario.setIdLoja(1);
        
        usuario.setId(3);

        DaoUsuario dao = new DaoUsuario();
        dao.editar(usuario);
        
        
    }
}
