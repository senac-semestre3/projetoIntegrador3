/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.cliente;

import br.onevision.rainhadasucata.dao.ClienteDao;

/**
 *
 * @author everton
 */
public class TesteExcluir {
    public static void main(String[] args) {
        
        int id = 1; // id de exclusão
        ClienteDao dao = new ClienteDao();
        dao.excluirCliente(id);
    }
}
