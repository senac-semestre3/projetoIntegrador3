/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteListar {

    public static void main(String[] args) throws Exception {

        DaoUsuario dao = new DaoUsuario();

        List<Usuario> usuarios = new ArrayList<>();
        
        //lista por cpf
        String cpf = "3";// cpf a ser buscado
        
        //listar por nome
        String nome = "ri";

        //usuarios = dao.listaPorCpf(cpf);// Chamada da dao listarPorCpf
        //usuarios = dao.listaPorNome(nome);// Chamada da dao listarPorNome
        
        usuarios = dao.listarTodos();// Chamada da dao listarTodos

        for (Usuario user : usuarios) {
            System.out.println("ID Usuário: " + user.getId());
            System.out.println("Nome: " + user.getNome());
            System.out.println("Sobrenome: " + user.getSobrenome());
            System.out.println("CPF: " + user.getCpfCnpj());
            System.out.println("Data Nascimento: " + user.getDataNascimento());
            System.out.println("Sexo: " + user.getSexo());
            System.out.println("Telefone: " + user.getTelefone());
            System.out.println("Celular: " + user.getCelular());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("CEP: " + user.getCep());
            System.out.println("Logradouro: " + user.getLogradouro());
            System.out.println("Numero: " + user.getNumero());
            System.out.println("Bairro: " + user.getBairro());
            System.out.println("Cidade: " + user.getCidade());
            System.out.println("Estado: " + user.getEstado());
            System.out.println("Complemento: " + user.getComplemento());
            System.out.println("Nome de Usuário: " + user.getNomeUsuario());
            System.out.println("Senha: " + user.getSenha());
            System.out.println("Status: " + user.getStatus());
            System.out.println("Data de Cadastro: " + user.getDataCadastro());
            System.out.println("ID Permissão: " + user.getIdPermissao());
            System.out.println("ID Loja: " + user.getIdLoja());
            System.out.println("**************************************");
            System.out.println("");
        }
    }
}
