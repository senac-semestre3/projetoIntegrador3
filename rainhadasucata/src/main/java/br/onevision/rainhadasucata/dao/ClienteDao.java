/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
import br.onevision.rainhadasucata.model.Cliente;
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
public class ClienteDao {

    private final Connection connection;

    public ClienteDao() {

        this.connection = DBConnector.getConexaoDB();
    }

    // INSERIR CLIENTE
    public void inserir(Cliente cliente) throws RuntimeException {
        String sql = "INSERT INTO clientes ("
                + "nome_clientes, "
                + "sobrenome_clientes, "
                + "cpf_cnpj_clientes, "
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

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpfCnpj());
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
            stmt.setString(15, cliente.getDataAtual());
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

    //EDITAR CLIENTE
    public void editarCliente(Cliente cliente) {

        // cria a string de parametro do sql
        String sql = "UPDATE clientes SET "
                + "nome_clientes = ?,"
                + "sobrenome_clientes = ?,"
                + "cpf_cnpj_clientes = ?,"
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

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSobrenome());
            stmt.setString(3, cliente.getCpfCnpj());
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
            stmt.executeUpdate();

            //Fecha conexão
            FecharConexao();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            FecharConexao();
        }
    }

    //DELETAR CLIENTE
    public void excluirCliente(int id) {

        String sql = "UPDATE clientes SET deletado_clientes = true WHERE id_clientes = " + id;

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

    //OBTEM O CLIENTE PELO ID
    public Cliente obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM clientes WHERE id_clientes = " + id + " AND deletado_clientes = false";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id_clientes"));
                cliente.setNome(result.getString("nome_clientes"));
                cliente.setSobrenome(result.getString("sobrenome_clientes"));
                cliente.setCpfCnpj(result.getString("cpf_cnpj_clientes"));
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

                return cliente;

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

    //RETORNA UMA LISTA DE CLIENTES BUSCADO POR CPF/CNPJ
    public List<Cliente> listaPorCpfCnpj(String cpf_cnpj)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE cpf_cnpj_clientes LIKE '%" + cpf_cnpj + "%' AND deletado_clientes = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE CLIENTES BUSCADOS PELO NOME
    public List<Cliente> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE nome_clientes LIKE '%" + nome + "%' AND deletado_clientes = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA COM TODOS OS CLIENTES
    public List<Cliente> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM clientes WHERE deletado_clientes = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }
   

    // CRIA UMA LISTA DE CLIENTES E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
    public List<Cliente> criaLista(String sql) {

        //cria uma lista de clientes
        List<Cliente> clientes = new ArrayList<>();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os clientes 
            //encotrados na lista de clientes inicialmente declarada.
            while (result.next()) {
                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id_clientes"));
                cliente.setNome(result.getString("nome_clientes"));
                cliente.setSobrenome(result.getString("sobrenome_clientes"));
                cliente.setCpfCnpj(result.getString("cpf_cnpj_clientes"));
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
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            FecharConexao();
        }
        return clientes;
    }
}
