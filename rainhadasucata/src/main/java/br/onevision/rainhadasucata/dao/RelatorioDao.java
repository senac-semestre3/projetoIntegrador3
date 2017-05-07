/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.ItemDeVenda;
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
public class RelatorioDao {

    private final Connection connection;

    public RelatorioDao() {

        this.connection = DBConnector.getConexaoDB();
    }

    public List<Relatorio> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT "
                + "  `vendas`.`id_vendas`, "
                + "  `usuarios`.`nome_usuarios`, "
                + "  `vendas`.`metodo_pagamento`, "
                + "  `vendas`.`data_hora_vendas`, "
                + "  `vendas`.`valor_total`, "
                + "  `produtos`.`nome_produto`, "
                + "  `itens_de_vendas`.`quantidade_idv`, "
                + "  `produtos`.`preco_venda_produto` "
                + "FROM "
                + "  `produtos` "
                + "LEFT JOIN "
                + "  `itens_de_vendas` ON `itens_de_vendas`.`fk_id_produto` = `produtos`.`id_produtos` "
                + "LEFT JOIN "
                + "  `vendas` ON `itens_de_vendas`.`fk_id_venda` = `vendas`.`id_vendas` "
                + "LEFT JOIN "
                + "  `usuarios` ON `vendas`.`id_vendas` = `usuarios`.`id_usuarios`";

        //chama o método de criar lista e à retorna
        return geraRelatorio(sql);
    }

    public List<Relatorio> geraRelatorio(String sql) {

        //cria uma lista de clientes
        List<Relatorio> relatorios = new ArrayList<>();
        List<ItemDeVenda> itens = new ArrayList<>();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                Relatorio relatorio = new Relatorio();
                Usuario usuario = new Usuario();
                Cliente cliente = new Cliente();
                Produto produto = new Produto();
                ItemDeVenda itemDeVenda = new ItemDeVenda();

                relatorio.setIdVenda(result.getInt("id_vendas"));
                
                //Seta o nome do cliente no relatório
                cliente.setNome(result.getString("nome_clientes"));
                relatorio.setCliente(cliente);
                
                //Seta o nome do vendedor no relatório
                usuario.setNome(result.getString("nome_usuarios"));
                relatorio.setUsuario(usuario);
                
                relatorio.setMetodoPagamento(result.getString("metodo_pagamento"));
                relatorio.setDataHora(result.getString("data_hora_vendas"));
                relatorio.setTotal(result.getDouble("valor_total"));
                
                while(result.next()){

                    produto.setNome(result.getString("nome_produto"));
                    itemDeVenda.setProduto(produto);
                    itemDeVenda.setQuantidade(result.getInt("quantidade_idv"));
                    itemDeVenda.setSubtotal();
                    
                    itens.add(itemDeVenda);
                }
                
                // Seta a lista de itens no relatório
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
