/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.model;

/**
 *
 * @author everton
 */
public class Conversao {

    private String[] quebraData(String data) {
        
        String dia;
        String mes;
        String ano;

        int posicaoEspaco = data.indexOf(" ");
        dia = data.substring(0, posicaoEspaco);
        if (dia.length() < 2) {
            dia = "0" + dia;
        }

        int posicaoVirgula = data.indexOf(",");
        mes = data.substring(posicaoEspaco, posicaoVirgula).trim();
        ano = data.substring(posicaoVirgula).replaceAll(",", "").trim();
        
        
        String[] novaData = {dia, mes, ano};
        return novaData;
        
        
    }

    private String coverteMes(String mes) {

        switch (mes) {
            case "January":
                return "01";

            case "February":
                return "02";

            case "March":
                return "03";

            case "April":
                return "04";

            case "May":
                return "05";

            case "June":
                return "06";

            case "July":
                return "07";

            case "August":
                return "08";

            case "September":
                return "09";

            case "October":
                return "10";

            case "November":
                return "11";

            case "December":
                return "12";

            default:
                return null;

        }

    }

    public String dataDb(String data){
        
        String[] vetor = quebraData(data);
        return vetor[2] + "-" +coverteMes(vetor[1]) + "-" + vetor[0];
    }

    public String dataNormal(String data){
        
        String[] vetor = quebraData(data);
        return vetor[0] + "/" + coverteMes(vetor[1]) + "/" + vetor[2];
    }

}
