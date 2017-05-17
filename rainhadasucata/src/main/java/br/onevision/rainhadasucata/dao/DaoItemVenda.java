/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
import br.onevision.rainhadasucata.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author everton
 */
public class DaoItemVenda {

    private final Connection connection;

    public DaoItemVenda() throws SQLException {

        this.connection = DBConnector.getConexaoDB();
    }

    // INSERIR VENDA
    public void inserir(List<ItemVenda> item, int idVenda)
            throws RuntimeException, SQLException {

        String sql = "INSERT INTO itens_de_vendas ("
                + "quantidade_idv, "
                + "fk_id_venda, "
                + "fk_id_produto, "
                + "subtotal_idv ) "
                + "VALUES (?, ?, ?, ?)";

        try ( // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            for (int i = 0; i < item.size(); i++) {
                System.out.println("Tamanho do Item: " + item.size());
                stmt.setInt(1, item.get(i).getQuantidade());
                stmt.setInt(2, idVenda);
                stmt.setInt(3, item.get(i).getProduto().getId());
                System.out.println("Id Produto: " + item.get(i).getProduto().getId());
                stmt.setDouble(4, item.get(i).calculaSubtotal());
                System.out.println("Subtotal: " + item.get(i).calculaSubtotal());

                //Executa SQL Statement
                stmt.execute();
            }

            //Fecha stmt
            stmt.close();
            //Fecha conexão
            FecharConexao();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            FecharConexao();
        }
        //Fecha conexão
        FecharConexao();

    }
}
