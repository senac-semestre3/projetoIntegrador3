/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.model.Cliente;

/**
 *
 * @author everton
 */
public class TesteObter {

    public static void main(String[] args) throws Exception {
        Cliente cliente;
        DaoCliente dao = new DaoCliente();

        int id = 3;// id a ser buscado

        cliente = dao.obter(id);

        System.out.println("ID Cliente: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Sobrenome: " + cliente.getSobrenome());
        System.out.println("CPF: " + cliente.getCpfCnpj());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Celular: " + cliente.getCelular());
        System.out.println("E-mail: " + cliente.getEmail());
        System.out.println("CEP: " + cliente.getCep());
        System.out.println("Logradouro: " + cliente.getLogradouro());
        System.out.println("Numero: " + cliente.getNumero());
        System.out.println("Bairro: " + cliente.getBairro());
        System.out.println("Cidade: " + cliente.getCidade());
        System.out.println("Estado: " + cliente.getEstado());
        System.out.println("Complemento: " + cliente.getComplemento());
        System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
        System.out.println("**************************************");

    }
}
