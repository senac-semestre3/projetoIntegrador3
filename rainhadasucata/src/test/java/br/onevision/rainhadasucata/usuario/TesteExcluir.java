/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import java.sql.SQLException;

/**
 *
 * @author everton
 */
public class TesteExcluir {
    public static void main(String[] args) throws SQLException {
        
        int id = 3; // id de exclusão
        DaoUsuario dao = new DaoUsuario();
        dao.excluir(id);
    }
}
