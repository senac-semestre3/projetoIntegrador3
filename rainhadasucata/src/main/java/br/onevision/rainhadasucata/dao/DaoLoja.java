/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import br.onevision.rainhadasucata.model.DataEHora;
import br.onevision.rainhadasucata.model.Loja;
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
public class DaoLoja {

    // INSERIR LOJA
    public void inserir(Loja loja)
            throws RuntimeException, SQLException {

        String sql = "INSERT INTO lojas ("
                + "nome_lojas, "
                + "cnpj_lojas, "
                + "telefone_lojas, "
                + "email_lojas, "
                + "cep_lojas, "
                + "logradouro_lojas, "
                + "numero_lojas, "
                + "bairro_lojas, "
                + "cidade_lojas, "
                + "estado_lojas, "
                + "data_cadastro_lojas, "
                + "deletado_lojas )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            DataEHora data = new DataEHora();

            //Seta valores para inserção
            stmt.setString(1, loja.getNome());
            stmt.setString(2, loja.getCnpj());
            stmt.setString(3, loja.getTelefone());
            stmt.setString(4, loja.getEmail());
            stmt.setString(5, loja.getCep());
            stmt.setString(6, loja.getLogradouro());
            stmt.setString(7, loja.getNumero());
            stmt.setString(8, loja.getBairro());
            stmt.setString(9, loja.getCidade());
            stmt.setString(10, loja.getEstado());
            stmt.setString(11, data.getDataEHoraAtual());
            stmt.setBoolean(12, loja.getDeletado());

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

    //EDITAR LOJA
    public void editar(Loja loja) 
            throws SQLException {

        // cria a string de parametro do sql
        String sql = "UPDATE lojas SET "
                + "nome_lojas = ?,"
                + "cnpj_lojas = ?,"
                + "telefone_lojas = ?,"
                + "email_lojas = ?,"
                + "cep_lojas = ?, "
                + "logradouro_lojas = ?, "
                + "numero_lojas = ?, "
                + "bairro_lojas = ?, "
                + "cidade_lojas = ?, "
                + "estado_lojas = ? "
                + "WHERE id_lojas = ?";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            //Seta valores para inserção
            stmt.setString(1, loja.getNome());
            stmt.setString(2, loja.getCnpj());
            stmt.setString(3, loja.getTelefone());
            stmt.setString(4, loja.getEmail());
            stmt.setString(5, loja.getCep());
            stmt.setString(6, loja.getLogradouro());
            stmt.setString(7, loja.getNumero());
            stmt.setString(8, loja.getBairro());
            stmt.setString(9, loja.getCidade());
            stmt.setString(10, loja.getEstado());
            stmt.setInt(11, loja.getId());

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
    
    
    //DELETAR LOJA
    public void excluir(int id) throws SQLException {

        String sql = "UPDATE lojas SET deletado_lojas = true WHERE id_lojas = " + id;

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
    
    
    //OBTEM O LOJA PELO ID
    public Loja obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM lojas WHERE id_lojas = " + id + " AND deletado_lojas = false";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {

            while (result.next()) {

                Loja loja = new Loja();

                loja.setId(result.getInt("id_lojas"));
                loja.setNome(result.getString("nome_lojas"));
                loja.setCnpj(result.getString("cnpj_lojas"));
                loja.setTelefone(result.getString("telefone_lojas"));
                loja.setEmail(result.getString("email_lojas"));
                loja.setCep(result.getString("cep_lojas"));
                loja.setLogradouro(result.getString("logradouro_lojas"));
                loja.setNumero(result.getString("numero_lojas"));
                loja.setBairro(result.getString("bairro_lojas"));
                loja.setCidade(result.getString("cidade_lojas"));
                loja.setEstado(result.getString("estado_lojas"));
                loja.setDataCadastro(result.getString("data_cadastro_lojas"));

                result.close();
                //Fecha stmt
                stmt.close();
                // Fecha a conexao
                connection.close();
                return loja;
            }
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
        return null;
    }
    
    
    //RETORNA UMA LISTA DE LOJAS BUSCADO POR CNPJ
    public List<Loja> listaPorCnpj(String cnpj)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM lojas WHERE cnpj_lojas LIKE '%" + cnpj + "%' AND deletado_lojas = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE LOJAS BUSCADOS PELO NOME
    public List<Loja> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM lojas WHERE nome_lojas LIKE '%" + nome + "%' AND deletado_lojas = false";

        //chama o metodo de criar lista e a retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA COM TODOS AS LOJAS
    public List<Loja> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM lojas WHERE deletado_lojas = false";

        //chama o método de criar lista e a retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE CLIENTES E RETORNA ESSA LISTA PARA O METODO QUE À CHAMOU
    private List<Loja> criaLista(String sql) throws SQLException {

        //cria uma lista de lojas
        List<Loja> lojas = new ArrayList<>();

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);
        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {

            //Percorre o resultado da query criando e adicionando os lojas 
            //encotrados na lista de lojas inicialmente declarada.
            while (result.next()) {
                Loja loja = new Loja();

                loja.setId(result.getInt("id_lojas"));
                loja.setNome(result.getString("nome_lojas"));
                loja.setCnpj(result.getString("cnpj_lojas"));
                loja.setTelefone(result.getString("telefone_lojas"));
                loja.setEmail(result.getString("email_lojas"));
                loja.setCep(result.getString("cep_lojas"));
                loja.setLogradouro(result.getString("logradouro_lojas"));
                loja.setNumero(result.getString("numero_lojas"));
                loja.setBairro(result.getString("bairro_lojas"));
                loja.setCidade(result.getString("cidade_lojas"));
                loja.setEstado(result.getString("estado_lojas"));
                loja.setDataCadastro(result.getString("data_cadastro_lojas"));

                lojas.add(loja);

            }

            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            
            return lojas;

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
        return lojas;
    }

}
