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
public class TesteInserir {
    public static void main(String[] args) throws RuntimeException, Exception {
        
        Cliente cliente = new Cliente();
        
        cliente.setNome("João");
        cliente.setCpfCnpj("411.439.000-88");
        cliente.setSexo("M");
        cliente.setTelefone("(11)5515-2677");
        cliente.setCelular("(11)95166-9431");
        cliente.setEmail("joao@outlook.com");
        cliente.setCep("04918110");
        cliente.setLogradouro("Rua Hélio Jacy Gouveia");
        cliente.setNumero("42");
        cliente.setBairro("Jardim São Francisco");
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");
        cliente.setComplemento("Casa 4");
        
        DaoCliente dao = new DaoCliente();
        dao.inserir(cliente);
    }
}
