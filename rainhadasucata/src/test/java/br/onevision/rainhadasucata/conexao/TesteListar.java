/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.conexao;

import br.onevision.rainhadasucata.dao.ClienteDao;
import br.onevision.rainhadasucata.dao.UsuarioDao;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteListar {

    public static void main(String[] args) throws Exception {

        ClienteDao dao = new ClienteDao();

        List<Cliente> cliente = new ArrayList<>();
        
        //lista por cpf
        String cpf = "3";// cpf a ser buscado
        
        //listar por nome
        String nome = "Wil";

        //usuarios = dao.listaPorCpf(cpf);// Chamada da dao listarPorCpf
        //usuarios = dao.listaPorNome(nome);// Chamada da dao listarPorNome
        
        cliente = dao.listarTodos();// Chamada da dao listarTodos

        for (Cliente cli : cliente) {
            System.out.println("ID Usuário: " + cli.getId());
            System.out.println("Nome: " + cli.getNome());
            System.out.println("Sobrenome: " + cli.getSobrenome());
            System.out.println("CPF/CNPJ: " + cli.getCpfCnpj());
            System.out.println("Sexo: " + cli.getSexo());
            System.out.println("Telefone: " + cli.getTelefone());
            System.out.println("Celular: " + cli.getCelular());
            System.out.println("E-mail: " + cli.getEmail());
            System.out.println("CEP: " + cli.getCep());
            System.out.println("Logradouro: " + cli.getLogradouro());
            System.out.println("Número: " + cli.getNumero());
            System.out.println("Bairro: " + cli.getBairro());
            System.out.println("Cidade: " + cli.getCidade());
            System.out.println("Estado: " + cli.getEstado());
            System.out.println("Complemento: " + cli.getComplemento());
            System.out.println("Deletado: " + cli.getDeletado());
            System.out.println("**************************************");
            System.out.println("");
        }
    }
}
