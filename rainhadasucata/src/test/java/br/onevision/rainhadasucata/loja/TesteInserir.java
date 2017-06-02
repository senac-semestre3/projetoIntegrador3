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
public class TesteInserir {
    public static void main(String[] args) throws RuntimeException, Exception {
        
        Loja loja = new Loja();
        
        loja.setNome("Rainha SP");
        loja.setCnpj("411.439.000-88");
        loja.setTelefone("(11)5515-2677");
        loja.setEmail("everton@outlook.com");
        loja.setCep("049181-10");
        loja.setLogradouro("Rua Hélio Jacy Gouveia");
        loja.setNumero("42");
        loja.setBairro("Jardim São Francisco");
        loja.setCidade("São Paulo");
        loja.setEstado("SP");
        
        DaoLoja dao = new DaoLoja();
        dao.inserir(loja);
        System.out.println("Inserido com sucesso");
    }
}
