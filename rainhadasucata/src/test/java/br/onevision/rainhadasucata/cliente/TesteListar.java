/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteListar {

    public static void main(String[] args) throws Exception {

        DaoCliente dao = new DaoCliente();

        List<Cliente> clientes = new ArrayList<>();
        
        //lista por cpf
        String cpf = "88";// cpf a ser buscado
        
        //listar por nome
        String nome = "Mar";

        //clientes = dao.listaPorCpfCnpj(cpf);// Chamada da dao listarPorCpf
        //clientes = dao.listaPorNome(nome);// Chamada da dao listarPorNome
        
        clientes = dao.listarTodos();// Chamada da dao listarTodos

        for (Cliente cli : clientes) {
            System.out.println("ID Cliente: " + cli.getId());
            System.out.println("Nome: " + cli.getNome());
            System.out.println("CPF: " + cli.getCpf());
            System.out.println("Sexo: " + cli.getSexo());
            System.out.println("Telefone: " + cli.getTelefone());
            System.out.println("Celular: " + cli.getCelular());
            System.out.println("E-mail: " + cli.getEmail());
            System.out.println("CEP: " + cli.getCep());
            System.out.println("Logradouro: " + cli.getLogradouro());
            System.out.println("Numero: " + cli.getNumero());
            System.out.println("Bairro: " + cli.getBairro());
            System.out.println("Cidade: " + cli.getCidade());
            System.out.println("Estado: " + cli.getEstado());
            System.out.println("Complemento: " + cli.getComplemento());
            System.out.println("Data de Cadastro: " + cli.getDataCadastro());
            System.out.println("**************************************");
            System.out.println("");
        }
    }
}
