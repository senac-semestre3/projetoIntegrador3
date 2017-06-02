/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;

/**
 *
 * @author everton
 */
public class TesteInserir {
    public static void main(String[] args) throws RuntimeException, Exception {
        
        Usuario usuario = new Usuario();
        
        usuario.setNome("Maria");
        usuario.setCpf("411.439.358.70");
        usuario.setDataNascimento("11 May, 2017"); // insere data teste
        usuario.setSexo("M");
        usuario.setTelefone("(11)5515-2677");
        usuario.setCelular("(11)95166-9431");
        usuario.setEmail("everton_roliveira@outlook.com");
        usuario.setCep("04918110");
        usuario.setLogradouro("Rua Hélio Jacy Gouveia");
        usuario.setNumero("42");
        usuario.setBairro("Jardim São Francisco");
        usuario.setCidade("São Paulo");
        usuario.setEstado("SP");
        usuario.setComplemento("Casa 4");
        usuario.setNomeUsuario("maria3");
        usuario.setSenha("P@ssw0rd");
        usuario.setStatus(0);
        usuario.setIdPermissao(1);
        usuario.setIdLoja(1);
        
        DaoUsuario daoUsuario = new DaoUsuario();
        daoUsuario.inserir(usuario);
    }
}
