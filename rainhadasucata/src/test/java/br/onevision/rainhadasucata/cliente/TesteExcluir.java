/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import java.sql.SQLException;

/**
 *
 * @author everton
 */
public class TesteExcluir {
    public static void main(String[] args) throws SQLException {
        
        int id = 1; // id de exclusão
        DaoCliente dao = new DaoCliente();
        dao.excluirCliente(id);
    }
}
