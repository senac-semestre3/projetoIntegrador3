
import br.onevision.rainhadasucata.dao.DBConnector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author everton
 */
public class TesteConexao {
    public static void main(String[] args) {
        DBConnector connector = new DBConnector();
        DBConnector.getConexaoDB();
        DBConnector.statusConexao();
    }
}
