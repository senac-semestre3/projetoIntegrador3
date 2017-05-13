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
public class TesteEditar {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        
        cliente.setNome("Maria");
        cliente.setSobrenome("Ricardo");
        cliente.setCpfCnpj("411.439.000-55");
        cliente.setSexo("F");
        cliente.setTelefone("(11)5515-0000");
        cliente.setCelular("(11)95166-0000");
        cliente.setEmail("joao@outlook.com.br");
        cliente.setCep("000000");
        cliente.setLogradouro("Rua Hélio Jacy");
        cliente.setNumero("35");
        cliente.setBairro("Jardim São");
        cliente.setCidade("São Paulo Capital");
        cliente.setEstado("RJ");
        cliente.setComplemento("Casa 411");
        
        cliente.setId(3);

        DaoCliente dao = new DaoCliente();
        dao.editarCliente(cliente);
        
        
    }
}
