/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.loja;

import br.onevision.rainhadasucata.dao.DaoLoja;
import java.sql.SQLException;

/**
 *
 * @author everton
 */
public class TesteExcluir {
    public static void main(String[] args) throws SQLException {
        
        int id = 2; // id de exclusão
        DaoLoja dao = new DaoLoja();
        dao.excluir(id);
    }
}
