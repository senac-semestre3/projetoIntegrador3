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

    // Data que vem do front
    private String[] quebraDataFront(String data) {

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

    private String coverteMesNumero(String mes) {

        switch (mes) {
            case "Janeiro":
                return "01";

            case "Fevereiro":
                return "02";

            case "Março":
                return "03";

            case "Abril":
                return "04";

            case "Maio":
                return "05";

            case "Junho":
                return "06";

            case "Julio":
                return "07";

            case "Agosto":
                return "08";

            case "Setembro":
                return "09";

            case "Outubro":
                return "10";

            case "Novembro":
                return "11";

            case "Dezembro":
                return "12";

            default:
                return null;

        }

    }

    public String converteParaDb(String data) {
        System.out.println("data " + data);
        if (data.equals("") || data == null) {
            return "0000-00-00";
        }
        String[] vetor = new String[3];
        vetor = quebraDataFront(data);
        System.out.println(vetor[0]);
        System.out.println(vetor[1]);
        System.out.println(vetor[2]);
        return vetor[2] + "-" + coverteMesNumero(vetor[1]) + "-" + vetor[0];
    }

    
    // Data que vem do banco
    private String[] quebraDataDb(String data) {
        String dia;
        String mes;
        String ano;

        ano = data.substring(0, 4);
        mes = data.substring(5, 7);
        dia = data.substring(8);

        String[] novaData = {dia, mes, ano};
        return novaData;

    }

    public String converteDataNormal(String data) {
        String[] vetor = new String[3];

        vetor = quebraDataDb(data);
        System.out.println(vetor[0]);
        System.out.println(vetor[1]);
        System.out.println(vetor[2]);
        return vetor[0] + " " + coverteMesCaracter(vetor[1]) + ", " + vetor[2];
    }

    private String coverteMesCaracter(String mes) {

        switch (mes) {
            case "01":
                return "Janeiro";

            case "02":
                return "Fevereiro";

            case "03":
                return "Março";

            case "04":
                return "Abril";

            case "05":
                return "Maio";

            case "06":
                return "Junho";

            case "07":
                return "Julio";

            case "08":
                return "Agosto";

            case "09":
                return "Setembro";

            case "10":
                return "Outubro";

            case "11":
                return "Novembro";

            case "12":
                return "Dezembro";

            default:
                return null;

        }

    }
}
