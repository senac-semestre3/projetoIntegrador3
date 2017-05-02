/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
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
public class DaoUsuario {

    private final Connection connection;

    public DaoUsuario() {

        this.connection = new DBConnector().getConexaoDB();
    }

    // INSERIR USUÁRIO
    public void inserir(Usuario usuario) throws RuntimeException {
        String sql = "INSERT INTO usuarios ("
                + "nome, "
                + "sobrenome, "
                + "cpf, "
                + "sexo, "
                + "telefone, "
                + "celular, "
                + "email, "
                + "Lojas_id_loja, "
                + "nome_usuario, "
                + "senha, "
                + "status, "
                + "data_nascimento, "
                + "permissoes_id_permissao, "
                + "deletado )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Converte a data de nascimento do java para dataSql
            java.util.Date dataUtil = usuario.getDataNascimento();
            java.sql.Date data_nascimento = new java.sql.Date(dataUtil.getTime());

            //Seta valores para inserção
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, usuario.getEmail());
            stmt.setInt(8, usuario.getIdLoja());
            stmt.setString(9, usuario.getNomeUsuario());
            stmt.setString(10, usuario.getSenha());
            stmt.setBoolean(11, usuario.getStatus());
            stmt.setDate(12, data_nascimento);
            stmt.setInt(13, usuario.getIdPermissao());
            stmt.setBoolean(14, usuario.getDeletado());

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

    //EDITAR USUÁRIO
    public void editarUsuario(Usuario usuario) {

        Connection con = DBConnector.getConexaoDB();

        String sql = "UPDATE usuarios SET "
                + "nome = ?,"
                + "sobrenome = ?,"
                + "cpf = ?,"
                + "sexo = ?,"
                + "telefone = ?,"
                + "celular = ?,"
                + "email = ?,"
                + "Lojas_id_loja = ?,"
                + "nome_usuario = ?,"
                + "senha = ?,"
                + "status = ?,"
                + "data_nascimento = ?,"
                + "permissoes_id_permissao = ?,"
                + "deletado = ? "
                + "WHERE id_usuario = ?";

        try (
                // prepared statement para inserção
                PreparedStatement stmt = con.prepareStatement(sql)) {

            //Converte a data de nascimento do java para dataSql
            java.util.Date dataUtil = usuario.getDataNascimento();
            java.sql.Date data_nascimento = new java.sql.Date(dataUtil.getTime());

            //Seta valores para inserção
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, usuario.getEmail());
            stmt.setInt(8, usuario.getIdLoja());
            stmt.setString(9, usuario.getNomeUsuario());
            stmt.setString(10, usuario.getSenha());
            stmt.setBoolean(11, usuario.getStatus());
            stmt.setDate(12, data_nascimento);
            stmt.setInt(13, usuario.getIdPermissao());
            stmt.setBoolean(14, usuario.getDeletado());
            stmt.setInt(15, usuario.getId());

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
    
    //DELETAR USUÁRIO
    public void excluirUsuario(int id) {

        

        String sql = "UPDATE usuarios SET deletado = true WHERE id_usuario = " + id;

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção

            

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

    //OBTEM O USUÁRIO PELO ID
    public Usuario obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM usuarios WHERE id_usuario = " + id + " AND deletado = false";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os usuarios 
            //encotrados na lista de usuarios inicialmente declarada.
            while (result.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(result.getInt("id_usuario"));
                usuario.setNome(result.getString("nome"));
                usuario.setSobrenome(result.getString("sobrenome"));
                usuario.setCpf(result.getString("cpf"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setTelefone(result.getString("telefone"));
                usuario.setCelular(result.getString("celular"));
                usuario.setEmail(result.getString("email"));
                usuario.setIdLoja(result.getInt("Lojas_id_loja"));
                usuario.setNomeUsuario(result.getString("nome_usuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setStatus(result.getBoolean("status"));
                usuario.setIdPermissao(result.getInt("permissoes_id_permissao"));

                return usuario;

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

    //RETORNA UMA LISTA DE USUÁRIOS BUSCADO POR CPF
    public List<Usuario> listaPorCpf(String cpf)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE cpf LIKE '%" + cpf + "%' AND deletado = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE USUÁRIOS BUSCADOS PELO NOME
    public List<Usuario> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE nome LIKE '%" + nome + "%' AND deletado = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA COM TODOS OS USUÁRIOS
    public List<Usuario> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE deletado = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE USUÁRIOS E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
    public List<Usuario> criaLista(String sql) {

        //cria uma lista de usuarios
        List<Usuario> usuarios = new ArrayList<>();

        try {
            //Cria um statement para executar as instruções SQL
            PreparedStatement stmt = connection.prepareStatement(sql);
            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os usuarios 
            //encotrados na lista de usuarios inicialmente declarada.
            while (result.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(result.getInt("id_usuario"));
                usuario.setNome(result.getString("nome"));
                usuario.setSobrenome(result.getString("sobrenome"));
                usuario.setCpf(result.getString("cpf"));
                usuario.setSexo(result.getString("sexo"));
                usuario.setTelefone(result.getString("telefone"));
                usuario.setCelular(result.getString("celular"));
                usuario.setEmail(result.getString("email"));
                usuario.setIdLoja(result.getInt("Lojas_id_loja"));
                usuario.setNomeUsuario(result.getString("nome_usuario"));
                usuario.setSenha(result.getString("senha"));
                usuario.setStatus(result.getBoolean("status"));
                usuario.setIdPermissao(result.getInt("permissoes_id_permissao"));

                usuarios.add(usuario);

            }

            result.close();
            stmt.close();
            FecharConexao();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            FecharConexao();
        }
        return usuarios;
    }

}
