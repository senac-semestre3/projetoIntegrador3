package br.onevision.rainhadasucata.model;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import org.json.simple.JSONObject;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BuscaCep {
    private String cep;

    public BuscaCep(String cep) {
        this.cep = cep;
    }
    
    
    
    public JSONObject toJSON() throws IOException{
        JSONObject json = new JSONObject();
        json.put("logradouro", getLogradouro());
        json.put("bairro", getBairro());
        json.put("cidade", getCidade());
        json.put("estado", getUF());
        return json;
    }

    private String getLogradouro() throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + cep)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=streetAddress]");
            for (Element urlEndereco : urlPesquisa) {
                return urlEndereco.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cep;
    }

    private String getBairro() throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + cep)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("td:gt(1)");
            for (Element urlBairro : urlPesquisa) {
                return urlBairro.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cep;
    }

    private String getCidade() throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + cep)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressLocality]");
            for (Element urlCidade : urlPesquisa) {
                return urlCidade.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cep;
    }

    public String getUF() throws IOException {

        // ***************************************************
        try {

            Document doc = Jsoup
                    .connect("http://www.qualocep.com/busca-cep/" + cep)
                    .timeout(120000).get();
            Elements urlPesquisa = doc.select("span[itemprop=addressRegion]");
            for (Element urlUF : urlPesquisa) {
                return urlUF.text();
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cep;
    }

    private String getLatLong() throws IOException, ParseException {

        // ***************************************************
        try {

            if (cep.contains("-")) {
                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                + cep + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            } else {

                StringBuilder cepHif = new StringBuilder(cep);
                cepHif.insert(cep.length() - 3, '-');

                Document doc = Jsoup
                        .connect(
                                "http://maps.googleapis.com/maps/api/geocode/xml?address="
                                + cepHif + "&language=pt-BR&sensor=true")
                        .timeout(120000).get();
                Elements lat = doc.select("geometry").select("location")
                        .select("lat");
                Elements lng = doc.select("geometry").select("location")
                        .select("lng");
                for (Element Latitude : lat) {
                    for (Element Longitude : lng) {
                        return Latitude.text() + "," + Longitude.text();
                    }

                }
            }

        } catch (SocketTimeoutException e) {

        } catch (HttpStatusException w) {

        }
        return cep;
    }

}
