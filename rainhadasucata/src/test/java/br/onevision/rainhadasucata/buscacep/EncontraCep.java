/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.buscacep;

import br.onevision.rainhadasucata.model.BuscaCep;
import java.io.IOException;


/**
 *
 * @author everton
 */
public class EncontraCep {
    public static void main(String[] args) throws IOException {
        
        String cep = "05223070";
        
        BuscaCep encontra = new BuscaCep(cep);

        System.out.println(encontra.toJSON());
    }
}
