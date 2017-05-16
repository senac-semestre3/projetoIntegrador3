/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
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

    private final Connection connection;

    public DaoProduto() {

        this.connection = DBConnector.getConexaoDB();
    }

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

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecoCompra());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setDouble(6, produto.getMargemVenda());
            stmt.setInt(7, produto.getEstoque());
            stmt.setInt(8, produto.getEstoqueMinimo());
            stmt.setBoolean(9, produto.isStatus());
            
            //Executa SQL Statement
            stmt.execute();
            //Fecha stmt
            stmt.close();

            //Fecha conexão
            FecharConexao();

        } catch (SQLException e) {
            System.out.println("N�o executou");
            throw new RuntimeException(e);
        } finally {
            FecharConexao();
        }
    }

    //EDITAR PRODUTO
    public void editarProduto(Produto produto) {

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

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getMarca());
            stmt.setString(3, produto.getDescricao());
            stmt.setDouble(4, produto.getPrecoCompra());
            stmt.setDouble(5, produto.getPrecoVenda());
            stmt.setDouble(6, produto.getMargemVenda());
            stmt.setInt(7, produto.getEstoque());
            stmt.setInt(8, produto.getEstoqueMinimo());
            stmt.setBoolean(9, produto.isStatus());
            stmt.setInt(10, produto.getId());

            //Executa SQL Statement
            stmt.execute();

            //Fecha conexão
            FecharConexao();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FecharConexao();
        }

    }

    //DELETAR PRODUTO
    public void excluirProduto(int id) {

        String sql = "UPDATE produtos SET deletado_produtos = true WHERE id_produtos = " + id;

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Executa SQL Statement
            stmt.executeUpdate();

            //Fecha conexão
            FecharConexao();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            FecharConexao();
        }
    }

    //OBTEM O PRODUTO PELO ID
    public Produto obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM produtos WHERE id_produtos = " + id + " AND deletado_produtos = false";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

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
                produto.setEstoque(result.getInt("estoque_produtos"));
                produto.setEstoqueMinimo(result.getInt("estoque_minimo_produtos"));
                produto.setStatus(result.getBoolean("status_produtos"));

                return produto;

            }

            result.close();

        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            FecharConexao();
        }
        FecharConexao();
        return null;
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
    public List<Produto> listaPorMarca(String marca)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM produtos WHERE marca_produtos LIKE '%" + marca + "%' AND deletado_produtos = false";

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
    public List<Produto> listaCustomizada(String nome, String marca, Integer quantidade, Boolean status)
            throws SQLException, Exception {
        
        String sql;
                
        if (quantidade != null && status != null) {
            System.out.println("Todos os critérios Atendido");
            sql = "SELECT * FROM `produtos` "
                + "WHERE "
                + "nome_produtos LIKE '%" + nome + "%' AND "
                + "marca_produtos LIKE '%" + marca + "%' AND "
                + "estoque_produtos = " + quantidade + " AND "
                + "status_produtos = " + status
                    
                + " AND deletado_produtos = false ";
        }else if(quantidade == null && status != null){
            System.out.println("Quantidade " + quantidade);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                + "WHERE "
                + "nome_produtos LIKE '%" + nome + "%' AND "
                + "marca_produtos LIKE '%" + marca + "%' AND "
                + "status_produtos = " + status
                    
                + " AND deletado_produtos = false ";
        }else if (status == null && quantidade != null) {
            System.out.println("Status " + status);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                + "WHERE "
                + "nome_produtos LIKE '%" + nome + "%' AND "
                + "marca_produtos LIKE '%" + marca + "%' AND "
                + "estoque_produtos = " + quantidade

                + " AND deletado_produtos = false ";
        }else{
            System.out.println("Quantidade " + quantidade);
            System.out.println("Status " + status);
            System.out.println("");
            sql = "SELECT * FROM `produtos` "
                + "WHERE "
                + "nome_produtos LIKE '%" + nome + "%' AND "
                + "marca_produtos LIKE '%" + marca + "%'"
                    
                + " AND deletado_produtos = false ";
        }
        
        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE PRODUTOS E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
    public List<Produto> criaLista(String sql) {

        //cria uma lista de clientes
        List<Produto> produtos = new ArrayList<>();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

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
                produto.setEstoque(result.getInt("Eetoque_produtos"));
                produto.setEstoqueMinimo(result.getInt("estoque_minimo_produtos"));
                produto.setStatus(result.getBoolean("status_produtos"));

                produtos.add(produto);

            }

            result.close();
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            FecharConexao();
        }
        return produtos;
    }

    public void listaPorNome(Produto p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
