/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.loja;

import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.model.Loja;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteListar {

    public static void main(String[] args) throws Exception {

        DaoLoja dao = new DaoLoja();

        List<Loja> lojas = new ArrayList<>();
        
        //lista por cnpj
        String cnpj = "439";// cpf a ser buscado
        
        //listar por nome
        String nome = "Rainha";

        //lojas = dao.listaPorCnpj(cnpj);// Chamada da dao listarPorcnpj
        //lojas = dao.listaPorNome(nome);// Chamada da dao listarPorNome
        
        lojas = dao.listarTodos();// Chamada da dao listarTodos

        for (Loja loja : lojas) {
            System.out.println("ID Loja: " + loja.getId());
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
            System.out.println("");
        }
    }
}
