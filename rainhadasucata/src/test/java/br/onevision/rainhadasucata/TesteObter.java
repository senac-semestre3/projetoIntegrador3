/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;

/**
 *
 * @author everton
 */
public class TesteObter {

    public static void main(String[] args) throws Exception {
        Usuario usuario;
        DaoUsuario dao = new DaoUsuario();
        
        int id = 1;// id a ser buscado
        
        usuario = dao.obter(id);

        System.out.println("ID Usuário: " + usuario.getId());
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Sobrenome: " + usuario.getSobrenome());
        System.out.println("CPF: " + usuario.getCpf());
        System.out.println("Sexo: " + usuario.getSexo());
        System.out.println("Telefone: " + usuario.getTelefone());
        System.out.println("Celular: " + usuario.getCelular());
        System.out.println("E-mail: " + usuario.getEmail());
        System.out.println("ID Loja: " + usuario.getIdLoja());
        System.out.println("Nome de Usuário: " + usuario.getNomeUsuario());
        System.out.println("Senha: " + usuario.getSenha());
        System.out.println("Status: " + usuario.getStatus());
        System.out.println("ID Permissão: " + usuario.getIdPermissao());
        System.out.println("Deletado: " + usuario.getDeletado());
        System.out.println("**************************************");

    }
}
