/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.loja;

import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.model.Loja;
import java.sql.SQLException;

/**
 *
 * @author everton
 */
public class TesteEditar {
    public static void main(String[] args) throws SQLException {
        Loja loja = new Loja();
        
        loja.setNome("Rainha Rio");
        loja.setCnpj("411.439.000-55");
        loja.setTelefone("(11)5515-0000");
        loja.setEmail("joao@outlook.com.br");
        loja.setCep("00000-100");
        loja.setLogradouro("Rua Hélio Jacy");
        loja.setNumero("35");
        loja.setBairro("Jardim São");
        loja.setCidade("São Paulo Capital");
        loja.setEstado("RJ");
        
        loja.setId(2);

        DaoLoja dao = new DaoLoja();
        dao.editar(loja);
        
        
    }
}
