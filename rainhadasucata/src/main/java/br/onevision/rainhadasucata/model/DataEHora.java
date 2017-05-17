/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author everton
 */
public class DataEHora {
    
    
    // pega a data e hora atual 
    public String getDataEHoraAtual() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        java.util.Date dataAtual = new java.util.Date();
        return dateFormat.format(dataAtual);

    }
    
    public String convertDataParaDB(Date data) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(data);

    }
    
    public String convertDataDeDB(Date data) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data);

    }
}
