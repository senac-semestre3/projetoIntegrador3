/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.DataEHora;
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
public class DaoCliente {

    // INSERIR CLIENTE
    public void inserir(Cliente cliente)
            throws RuntimeException, SQLException {

        String sql = "INSERT INTO clientes ("
                + "nome_clientes, "
                + "cpf_clientes, "
                + "data_nascimento_clientes, "
                + "sexo_clientes, "
                + "telefone_clientes, "
                + "celular_clientes, "
                + "email_clientes, "
                + "cep_clientes, "
                + "logradouro_clientes, "
                + "numero_clientes, "
                + "bairro_clientes, "
                + "cidade_clientes, "
                + "estado_clientes, "
                + "complemento_clientes, "
                + "data_cadastro_clientes )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {
            DataEHora data = new DataEHora();
            //Seta valores para inserção
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getSexo());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCelular());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getCep());
            stmt.setString(9, cliente.getLogradouro());
            stmt.setString(10, cliente.getNumero());
            stmt.setString(11, cliente.getBairro());
            stmt.setString(12, cliente.getCidade());
            stmt.setString(13, cliente.getEstado());
            stmt.setString(14, cliente.getComplemento());
            stmt.setString(15, data.getDataEHoraAtual());
            System.out.println("agora " + data.getDataEHoraAtual());

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

    //EDITAR CLIENTE
    public void editarCliente(Cliente cliente) throws SQLException {

        // cria a string de parametro do sql
        String sql = "UPDATE clientes SET "
                + "nome_clientes = ?,"
                + "cpf_clientes = ?,"
                + "data_nascimento_clientes = ?,"
                + "sexo_clientes = ?,"
                + "telefone_clientes = ?,"
                + "celular_clientes = ?,"
                + "email_clientes = ?,"
                + "cep_clientes = ?, "
                + "logradouro_clientes = ?, "
                + "numero_clientes = ?, "
                + "bairro_clientes = ?, "
                + "cidade_clientes = ?, "
                + "estado_clientes = ?, "
                + "complemento_clientes = ? "
                + "WHERE id_clientes = ?";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        try {

            //Seta valores para inserção
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getSexo());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getCelular());
            stmt.setString(7, cliente.getEmail());
            stmt.setString(8, cliente.getCep());
            stmt.setString(9, cliente.getLogradouro());
            stmt.setString(10, cliente.getNumero());
            stmt.setString(11, cliente.getBairro());
            stmt.setString(12, cliente.getCidade());
            stmt.setString(13, cliente.getEstado());
            stmt.setString(14, cliente.getComplemento());
            stmt.setInt(15, cliente.getId());

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

    //DELETAR CLIENTE
    public void excluirCliente(int id) throws SQLException {

        String sql = "UPDATE clientes SET deletado_clientes = true WHERE id_clientes = " + id;

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

    //OBTEM O CLIENTE PELO ID
    public Cliente obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM clientes WHERE id_clientes = " + id + " AND deletado_clientes = false";

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);

        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {

            while (result.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id_clientes"));
                cliente.setNome(result.getString("nome_clientes"));
                cliente.setCpf(result.getString("cpf_clientes"));
                cliente.setDataNascimento(result.getString("data_nascimento_clientes"));
                cliente.setSexo(result.getString("sexo_clientes"));
                cliente.setTelefone(result.getString("telefone_clientes"));
                cliente.setCelular(result.getString("celular_clientes"));
                cliente.setEmail(result.getString("email_clientes"));
                cliente.setCep(result.getString("cep_clientes"));
                cliente.setLogradouro(result.getString("logradouro_clientes"));
                cliente.setNumero(result.getString("numero_clientes"));
                cliente.setBairro(result.getString("bairro_clientes"));
                cliente.setCidade(result.getString("cidade_clientes"));
                cliente.setEstado(result.getString("estado_clientes"));
                cliente.setComplemento(result.getString("complemento_clientes"));
                cliente.setDataCadastro(result.getString("data_cadastro_clientes"));

                result.close();
                //Fecha stmt
                stmt.close();
                // Fecha a conexao
                connection.close();
                return cliente;
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

    //RETORNA UMA LISTA DE CLIENTES BUSCADO POR CPF/CNPJ
    public List<Cliente> listaPorCpfCnpj(String cpf_cnpj)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE cpf_clientes LIKE '%" + cpf_cnpj + "%' AND deletado_clientes = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE CLIENTES BUSCADOS PELO NOME
    public List<Cliente> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE nome_clientes LIKE '%" + nome + "%' AND deletado_clientes = false";

        //chama o metodo de criar lista e a retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA COM TODOS OS CLIENTES
    public List<Cliente> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE deletado_clientes = false";

        //chama o método de criar lista e a retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE CLIENTES E RETORNA ESSA LISTA PARA O METODO QUE À CHAMOU
    private List<Cliente> criaLista(String sql) throws SQLException {

        //cria uma lista de clientes
        List<Cliente> clientes = new ArrayList<>();

        Connection connection = DBConnector.getConexaoDB();
        PreparedStatement stmt = connection.prepareStatement(sql);
        //Cria o objeto que recebe o resultado da  query executada
        ResultSet result = stmt.executeQuery();

        try {

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id_clientes"));
                cliente.setNome(result.getString("nome_clientes"));
                cliente.setCpf(result.getString("cpf_clientes"));
                cliente.setDataNascimento(result.getString("data_nascimento_clientes"));
                cliente.setSexo(result.getString("sexo_clientes"));
                cliente.setTelefone(result.getString("telefone_clientes"));
                cliente.setCelular(result.getString("celular_clientes"));
                cliente.setEmail(result.getString("email_clientes"));
                cliente.setCep(result.getString("cep_clientes"));
                cliente.setLogradouro(result.getString("logradouro_clientes"));
                cliente.setNumero(result.getString("numero_clientes"));
                cliente.setBairro(result.getString("bairro_clientes"));
                cliente.setCidade(result.getString("cidade_clientes"));
                cliente.setEstado(result.getString("estado_clientes"));
                cliente.setComplemento(result.getString("complemento_clientes"));
                cliente.setDataCadastro(result.getString("data_cadastro_clientes"));

                clientes.add(cliente);

            }

            result.close();
            //Fecha stmt
            stmt.close();
            // Fecha a conexao
            connection.close();
            
            return clientes;

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
