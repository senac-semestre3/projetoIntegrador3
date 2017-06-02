/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import br.onevision.rainhadasucata.model.Produto;
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
public class DaoProduto {

    // INSERIR PRODUTO
    public void inserir(Produto produto) throws RuntimeException, SQLException {
        String sql = "INSERT INTO produtos ("
                + "nome_produtos, "
                + "marca_produtos, "
                + "descricao_produtos, "
                + "preco_compra_produtos, "
                + "preco_venda_produtos, "
                + "margem_venda_produtos, "
                + "estoque_produtos, "
                + "estoque_minimo_produtos, "
                + "status_produtos )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            //Seta valores para inserção
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecoCompra());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setDouble(6, produto.getMargemVenda());
            stmt.setInt(7, produto.getEstoque());
            stmt.setInt(8, produto.getEstoqueMinimo());
            stmt.setInt(9, produto.getStatus());

            //Executa SQL Statement
            stmt.execute();

        } catch (SQLException e) {

            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            throw new RuntimeException(e);
        } finally {
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
        }
    }

    //EDITAR PRODUTO
    public void editar(Produto produto) throws SQLException {

        // cria a string de parametro do sql
        String sql = "UPDATE produtos SET "
                + "nome_produtos = ?, "
                + "marca_produtos = ?, "
                + "descricao_produtos = ?, "
                + "preco_compra_produtos = ?, "
                + "preco_venda_produtos = ?, "
                + "margem_venda_produtos = ?, "
                + "estoque_produtos = ?, "
                + "estoque_minimo_produtos = ?, "
                + "status_produtos = ? "
                + "WHERE id_produtos = ?";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            //Seta valores para inserção
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecoCompra());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setDouble(6, produto.getMargemVenda());
            stmt.setInt(7, produto.getEstoque());
            stmt.setInt(8, produto.getEstoqueMinimo());
            stmt.setInt(9, produto.getStatus());
            stmt.setInt(10, produto.getId());

            //Executa SQL Statement
            stmt.execute();

        } catch (SQLException e) {
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();

            System.out.println(e);
        } finally {
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
        }
    }

    //DELETAR PRODUTO
    public void excluir(int id) throws SQLException {

        String sql = "UPDATE produtos SET deletado_produtos = true WHERE id_produtos = " + id;

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            //Executa SQL Statement
            stmt.execute();

            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();

        } catch (SQLException e) {
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            System.out.println(e);

        } finally {
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
        }
    }

    //OBTEM O PRODUTO PELO ID
    public Produto obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produtos WHERE id_produtos = " + id + " AND deletado_produtos = false";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {
            
            Produto produto = new Produto();
            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                
                
                produto.setId(result.getInt("id_produtos"));
                produto.setNome(result.getString("nome_produtos"));
                produto.setMarca(result.getString("marca_produtos"));
                produto.setDescricao(result.getString("descricao_produtos"));
                produto.setPrecoCompra(result.getDouble("preco_compra_produtos"));
                produto.setPrecoVenda(result.getDouble("preco_venda_produtos"));
                produto.setMargemVenda(result.getDouble("margem_venda_produtos"));
                produto.setEstoque(result.getInt("estoque_produtos"));
                produto.setEstoqueMinimo(result.getInt("estoque_minimo_produtos"));
                produto.setStatus(result.getInt("status_produtos"));

            }
            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            return produto;

        } catch (Exception e) {
            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            throw new SQLException(e);

        } finally {
            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
        }
    }

    //RETORNA UMA LISTA COM TODOS OS PRODUTOS
    public List<Produto> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE deletado_produtos = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE PRODUTOS BUSCADOS PELO NOME
    public List<Produto> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE nome_produtos LIKE '%" + nome + "%' AND deletado_produtos = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE PRODUTOS BUSCADOS PELA MARCA
    public List<Produto> listaPorPrecoVenda(String preco)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE preco_venda_produtos LIKE '%" + preco + "%' AND deletado_produtos = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE PRODUTOS BUSCADOS POR QUANTIDADE
    public List<Produto> listaPorQuantidade(Integer quantidade)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE estoque_produtos = " + quantidade + " AND deletado_produtos = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE PRODUTOS BUSCADOS PELO STATUS
    public List<Produto> listaPorStatus(Boolean status)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE status_produtos = " + status + " AND deletado_produtos = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    // RETORNA UMA LISTA CUSTOMIZADA
    public List<Produto> listaCustomizada(String nome, String preco, Integer quantidade, Boolean status)
            throws SQLException, Exception {

        String sql;

            if (quantidade != null && status != null) {
            System.out.println("Todos os critérios Atendido");
            sql = "SELECT * FROM `produtos` "
                    + "WHERE "
                    + "nome_produtos LIKE '%" + nome + "%' AND "
                    + "preco_venda_produtos LIKE '%" + preco + "%' AND "
                    + "estoque_produtos = " + quantidade + " AND "
                    + "status_produtos = " + status
                    + " AND deletado_produtos = false ";
        } else if (quantidade == null && status != null) {
            System.out.println("Quantidade " + quantidade);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                    + "WHERE "
                    + "nome_produtos LIKE '%" + nome + "%' AND "
                    + "preco_venda_produtos LIKE '%" + preco + "%' AND "
                    + "status_produtos = " + status
                    + " AND deletado_produtos = false ";
        } else if (status == null && quantidade != null) {
            System.out.println("Status " + status);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                    + "WHERE "
                    + "nome_produtos LIKE '%" + nome + "%' AND "
                    + "preco_venda_produtos LIKE '%" + preco + "%' AND "
                    + "estoque_produtos = " + quantidade
                    + " AND deletado_produtos = false ";
        } else {
            System.out.println("Quantidade " + quantidade);
            System.out.println("Status " + status);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                    + "WHERE "
                    + "nome_produtos LIKE '%" + nome + "%' AND "
                    + "preco_venda_produtos LIKE '%" + preco + "%'"
                    + " AND deletado_produtos = false ";
        }

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE PRODUTOS E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
    private List<Produto> criaLista(String sql) throws SQLException {

        //cria uma lista de clientes
        List<Produto> produtos = new ArrayList<>();
        
        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);
        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {
            
            
            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                Produto produto = new Produto();
                produto.setId(result.getInt("id_produtos"));
                produto.setNome(result.getString("nome_produtos"));
                produto.setMarca(result.getString("marca_produtos"));
                produto.setDescricao(result.getString("descricao_produtos"));
                produto.setPrecoCompra(result.getDouble("preco_compra_produtos"));
                produto.setPrecoVenda(result.getDouble("preco_venda_produtos"));
                produto.setMargemVenda(result.getDouble("margem_venda_produtos"));
                produto.setEstoque(result.getInt("Estoque_produtos"));
                produto.setEstoqueMinimo(result.getInt("estoque_minimo_produtos"));
                produto.setStatus(result.getInt("status_produtos"));

                produtos.add(produto);

            }

            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            
            return produtos;

        } catch (Exception e) {
            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            System.out.println(e.getMessage());
        } finally {
            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
        }
        return null;
    }
}
