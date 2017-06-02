/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.loja;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Loja;

/**
 *
 * @author everton
 */
public class TesteObter {

    public static void main(String[] args) throws Exception {
        Loja loja;
        DaoLoja dao = new DaoLoja();

        int id = 3;// id a ser buscado

        loja = dao.obter(id);

        System.out.println("ID Cliente: " + loja.getId());
        System.out.println("Nome: " + loja.getNome());
        System.out.println("CNPJ: " + loja.getCnpj());
        System.out.println("Telefone: " + loja.getTelefone());
        System.out.println("E-mail: " + loja.getEmail());
        System.out.println("CEP: " + loja.getCep());
        System.out.println("Logradouro: " + loja.getLogradouro());
        System.out.println("Numero: " + loja.getNumero());
        System.out.println("Bairro: " + loja.getBairro());
        System.out.println("Cidade: " + loja.getCidade());
        System.out.println("Estado: " + loja.getEstado());
        System.out.println("Data de Cadastro: " + loja.getDataCadastro());
        System.out.println("**************************************");

    }
}
