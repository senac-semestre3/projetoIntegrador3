/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.dao;

import static br.onevision.rainhadasucata.dao.DBConnector.FecharConexao;
import br.onevision.rainhadasucata.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public DaoUsuario() throws SQLException {

        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        this.connection = DBConnector.getConexaoDB();
    }

    // INSERIR USUARIO
    public void inserir(Usuario usuario) throws RuntimeException {
        String sql = "INSERT INTO usuarios ("
                + "nome_usuarios, "
                + "cpf_usuarios, "
                + "data_nascimento_usuarios, "
                + "sexo_usuarios, "
                + "telefone_usuarios, "
                + "celular_usuarios, "
                + "email_usuarios, "
                + "cep_usuarios, "
                + "logradouro_usuarios, "
                + "numero_usuarios, "
                + "bairro_usuarios, "
                + "cidade_usuarios, "
                + "estado_usuarios, "
                + "complemento_usuarios, "
                + "nome_login_usuarios, "
                + "senha_usuarios, "
                + "status_usuarios, "
                + "data_cadastro_usuarios, "
                + "fk_id_permissao, "
                + "fk_id_loja )"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Seta valores para inserção
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpfCnpj());
            stmt.setString(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, usuario.getEmail());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getLogradouro());
            stmt.setString(10, usuario.getNumero());
            stmt.setString(11, usuario.getBairro());
            stmt.setString(12, usuario.getCidade());
            stmt.setString(13, usuario.getEstado());
            stmt.setString(14, usuario.getComplemento());
            stmt.setString(15, usuario.getNomeUsuario());
            stmt.setString(16, usuario.getSenha());
            stmt.setInt(17, usuario.getStatus());
            stmt.setString(18, usuario.getDataAtual());
            stmt.setInt(19, usuario.getIdPermissao());
            stmt.setInt(20, usuario.getIdLoja());

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

    //EDITAR USU�?RIO
    public void editarUsuario(Usuario usuario) throws SQLException {

        Connection con = DBConnector.getConexaoDB();

        String sql = "UPDATE usuarios SET "
                + "nome_usuarios = ?, "
                + "cpf_usuarios = ?, "
                + "data_nascimento_usuarios = ?, "
                + "sexo_usuarios = ?, "
                + "telefone_usuarios = ?, "
                + "celular_usuarios = ?, "
                + "email_usuarios = ?, "
                + "cep_usuarios = ?, "
                + "logradouro_usuarios = ?, "
                + "numero_usuarios = ?, "
                + "bairro_usuarios = ?, "
                + "cidade_usuarios = ?, "
                + "estado_usuarios = ?, "
                + "complemento_usuarios = ?, "
                + "nome_login_usuarios = ?, "
                + "senha_usuarios = ?, "
                + "status_usuarios = ?, "
                + "fk_id_permissao = ?, "
                + "fk_id_loja = ? "
                + "WHERE id_usuarios = ?";

        try (
                // prepared statement para inserção
                PreparedStatement stmt = con.prepareStatement(sql)) {

            //Seta valores para Update
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpfCnpj());
            stmt.setString(3, usuario.getDataNascimento());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getTelefone());
            stmt.setString(6, usuario.getCelular());
            stmt.setString(7, usuario.getEmail());
            stmt.setString(8, usuario.getCep());
            stmt.setString(9, usuario.getLogradouro());
            stmt.setString(10, usuario.getNumero());
            stmt.setString(11, usuario.getBairro());
            stmt.setString(12, usuario.getCidade());
            stmt.setString(13, usuario.getEstado());
            stmt.setString(14, usuario.getComplemento());
            stmt.setString(15, usuario.getNomeUsuario());
            stmt.setString(16, usuario.getSenha());
            stmt.setInt(17, usuario.getStatus());
            stmt.setInt(18, usuario.getIdPermissao());
            stmt.setInt(19, usuario.getIdLoja());
            stmt.setInt(20, usuario.getId());

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

    //DELETAR USU�?RIO
    public void excluirUsuario(int id) {

        String sql = "UPDATE usuarios SET deletado_usuarios = true WHERE id_usuarios = " + id;

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

    //OBTEM O USU�?RIO PELO ID
    public Usuario obter(int id)
            throws SQLException, Exception {

        String sql = "SELECT * FROM usuarios WHERE id_usuarios = " + id + " AND deletado_usuarios = false";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os usuarios 
            //encotrados na lista de usuarios inicialmente declarada.
            while (result.next()) {
                Usuario usuario = new Usuario();

                usuario.setId(result.getInt("id_usuarios"));
                usuario.setNome(result.getString("nome_usuarios"));
                usuario.setCpfCnpj(result.getString("cpf_usuarios"));
                usuario.setDataNascimento(result.getString("data_nascimento_usuarios"));
                usuario.setSexo(result.getString("sexo_usuarios"));
                usuario.setTelefone(result.getString("telefone_usuarios"));
                usuario.setCelular(result.getString("celular_usuarios"));
                usuario.setEmail(result.getString("email_usuarios"));
                usuario.setCep(result.getString("cep_usuarios"));
                usuario.setLogradouro(result.getString("logradouro_usuarios"));
                usuario.setNumero(result.getString("numero_usuarios"));
                usuario.setBairro(result.getString("bairro_usuarios"));
                usuario.setCidade(result.getString("cidade_usuarios"));
                usuario.setEstado(result.getString("estado_usuarios"));
                usuario.setComplemento(result.getString("complemento_usuarios"));
                usuario.setNomeUsuario(result.getString("nome_login_usuarios"));
                usuario.setSenha(result.getString("senha_usuarios"));
                usuario.setStatus(result.getInt("status_usuarios"));
                usuario.setDataCadastro(result.getString("data_cadastro_usuarios"));
                usuario.setIdPermissao(result.getInt("fk_id_permissao"));
                usuario.setIdLoja(result.getInt("fk_id_loja"));

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

    //RETORNA UMA LISTA DE USU�?RIOS BUSCADO POR CPF
    public List<Usuario> listaPorCpf(String cpf)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE cpf_usuarios LIKE '%" + cpf + "%' AND deletado_usuarios = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA DE USU�?RIOS BUSCADOS PELO NOME
    public List<Usuario> listaPorNome(String nome)
            throws SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE nome_usuarios LIKE '%" + nome + "%' AND deletado_usuarios = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    //RETORNA UMA LISTA COM TODOS OS USU�?RIOS
    public List<Usuario> listarTodos() throws
            SQLException, Exception {

        // cria a query de busca
        String sql = "SELECT * FROM usuarios WHERE deletado_usuarios = false";

        //chama o método de criar lista e à retorna
        return criaLista(sql);
    }

    // CRIA UMA LISTA DE USU�?RIOS E RETORNA ESSA LISTA PARA O MÉTODO QUE À CHAMOU
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

                usuario.setId(result.getInt("id_usuarios"));
                usuario.setNome(result.getString("nome_usuarios"));
                usuario.setCpfCnpj(result.getString("cpf_usuarios"));
                usuario.setDataNascimento(result.getString("data_nascimento_usuarios"));
                usuario.setSexo(result.getString("sexo_usuarios"));
                usuario.setTelefone(result.getString("telefone_usuarios"));
                usuario.setCelular(result.getString("celular_usuarios"));
                usuario.setEmail(result.getString("email_usuarios"));
                usuario.setCep(result.getString("cep_usuarios"));
                usuario.setLogradouro(result.getString("logradouro_usuarios"));
                usuario.setNumero(result.getString("numero_usuarios"));
                usuario.setBairro(result.getString("bairro_usuarios"));
                usuario.setCidade(result.getString("cidade_usuarios"));
                usuario.setEstado(result.getString("estado_usuarios"));
                usuario.setComplemento(result.getString("complemento_usuarios"));
                usuario.setNomeUsuario(result.getString("nome_login_usuarios"));
                usuario.setSenha(result.getString("senha_usuarios"));
                usuario.setStatus(result.getInt("status_usuarios"));
                usuario.setDataCadastro(result.getString("data_cadastro_usuarios"));
                usuario.setIdPermissao(result.getInt("fk_id_permissao"));
                usuario.setIdLoja(result.getInt("fk_id_loja"));

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
//SELECT usuarios.nome_usuarios, usuarios.senha_usuarios FROM `usuarios` WHERE usuarios.nome_usuarios = "Willian" AND usuarios.senha_usuarios = 1234565

    public Usuario obterNomeSenha(String nome, String senha)
            throws SQLException, Exception {

        String sql ="SELECT usuarios.nome_usuarios, usuarios.senha_usuarios FROM `usuarios`"
                + " WHERE usuarios.nome_usuarios = \""+nome+"\" AND usuarios.senha_usuarios = "+senha+";";
//        String sql = "SELECT usuarios.nome_usuarios, usuarios.senha_usuarios FROM `usuarios` "
//                + "WHERE usuarios.nome_usuarios = \"Willian\" AND usuarios.senha_usuarios = 1234565";

        try (
                //Cria um statement para executar as instruções SQL
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            //Cria o objeto que recebe o resultado da  query executada
            ResultSet result = stmt.executeQuery();

            //Percorre o resultado da query criando e adicionando os usuarios 
            //encotrados na lista de usuarios inicialmente declarada.
            while (result.next()) {
                Usuario usuario = new Usuario();

             
                usuario.setNome(result.getString("nome_usuarios"));
             
               

                usuario.setSenha(result.getString("senha_usuarios"));
               
//                FecharConexao();

                return usuario;

            }

            result.close();
            FecharConexao();

        } catch (Exception e) {
            throw new SQLException(e);
        } finally {
            FecharConexao();
        }
        FecharConexao();
        return null;
    }

}
