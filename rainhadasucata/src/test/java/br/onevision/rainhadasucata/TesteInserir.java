/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata;

import br.onevision.rainhadasucata.dao.DBConnector;
import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;
import java.sql.Date;

/**
 *
 * @author everton
 */
public class TesteInserir {
    public static void main(String[] args) throws RuntimeException, Exception {
        DBConnector conexao = new DBConnector();

        conexao.getConexaoDB();
        System.out.println(conexao.statusConexao());
        
        Usuario usuario = new Usuario();
        
        usuario.setNome("Everton");
        usuario.setSobrenome("Roberto");
        usuario.setCpf("411.439.358.70");
        usuario.setSexo("M");
        usuario.setTelefone("(11)5515-2677");
        usuario.setCelular("(11)95166-9431");
        usuario.setEmail("everton_roliveira@outlook.com");
        usuario.setIdLoja(1);
        usuario.setNomeUsuario("everton.roliveira2");
        usuario.setSenha("P@ssw0rd");
        usuario.setStatus(true);
        usuario.setDataNascimento(Date.valueOf("1993-04-02")); // insere data teste
        usuario.setIdPermissao(1);
        
        DaoUsuario daoUsuario = new DaoUsuario();
        daoUsuario.inserir(usuario);
    }
}
