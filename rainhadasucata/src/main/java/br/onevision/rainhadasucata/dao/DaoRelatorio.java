/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Data;
import br.onevision.rainhadasucata.model.ItemVenda;
import br.onevision.rainhadasucata.model.Produto;
import br.onevision.rainhadasucata.model.Relatorio;
import br.onevision.rainhadasucata.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author everton
 */
public class DaoRelatorio {

    private final Connection connection;

    public DaoRelatorio() throws SQLException {

        this.connection = DBConnector.getConexaoDB();
    }

    public List<Relatorio> listarPorData(String dataI, String dataF) throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio WHERE data_hora BETWEEN "
                + dataI + " 23:59:59 AND " + dataF + " GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    public List<Relatorio> listarPorDataInicial(String dataI) throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio WHERE data_hora BETWEEN "
                + dataI + " 23:59:59 AND NOW() GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    public List<Relatorio> listarPorDataFinal(String dataF) throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio WHERE data_hora <= "
                + dataF + " 23:59:59 GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    public List<Relatorio> listarPorVendedor(int id) throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio WHERE id_usuario = " + id + " GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    public List<Relatorio> listarPorLoja(int id) throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio WHERE id_loja = " + id + " GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    public List<Relatorio> listarPorCliente(String nome) throws
            SQLException, Exception {

            String sql = "SELECT * FROM relatorio WHERE nome_cliente LIKE '%" + nome + "%'";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    
    
    public List<Relatorio> obterDetalhesRelatorio(String id) throws
            SQLException, Exception {

            String sql = "SELECT * FROM relatorio WHERE id_venda LIKE '%" + id + "%'";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }
    public List<Relatorio> listarTodos() throws
            SQLException, Exception {

        String sql = "SELECT * FROM relatorio GROUP BY id_venda";

        //chama o metodo de criar lista
        return geraRelatorio(sql);
    }

    // CRIA UMA LISTA DE PRODUTOS E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
    private List<Relatorio> geraRelatorio(String sql) {

        //cria uma lista de clientes
        List<Relatorio> relatorios = new ArrayList<>();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            Data data = new Data();
            

            while (result.next()) {

                Relatorio relatorio = new Relatorio();
                Cliente cliente = new Cliente();
                Usuario usuario = new Usuario();
                Produto produto = new Produto();
                ItemVenda item = new ItemVenda();
                List<ItemVenda> itens = new ArrayList<>();

                relatorio.setIdVenda(result.getInt("id_venda"));
                relatorio.setData(result.getString("data_hora"));
                cliente.setNome(result.getString("nome_cliente"));
                usuario.setId(result.getInt("id_usuario"));
                usuario.setNome(result.getString("nome_usuario"));
                relatorio.setMetodoPagamento(result.getString("metodo_pagamento"));
                relatorio.setTotal(result.getDouble("valor_total_venda"));

                for (int i = 0; i < itens.size(); i++) {

                    produto.setNome(result.getString("nome_produto"));
                    item.setProduto(produto);
                    item.setQuantidade(result.getInt("quantidade_produto"));
                    item.setSubtotal(result.getDouble("subtotal_produto"));
                    
                    itens.add(item);
                }
                
                relatorio.setCliente(cliente);
                relatorio.setUsuario(usuario);
                relatorio.setItens(itens);

                relatorios.add(relatorio);
                

            }

            result.close();
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            FecharConexao();
        }
        return relatorios;
    }
}
