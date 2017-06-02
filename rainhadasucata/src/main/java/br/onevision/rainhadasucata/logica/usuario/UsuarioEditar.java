/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.usuario;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Conversao;
import br.onevision.rainhadasucata.model.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class UsuarioEditar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Conversao conversao = new Conversao();
        Usuario usuario = new Usuario();

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String sexo = request.getParameter("sexo");
        String nascimento = request.getParameter("data-nascimento");
        nascimento = conversao.converteParaDb(nascimento);
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String complemento = request.getParameter("complemento");
        String estado = request.getParameter("estado");
        String NomeUsuario = request.getParameter("usuario-nome");
        String senha = request.getParameter("usuario-senha");
        String idPermissao = request.getParameter("permissao");
        String idLoja = request.getParameter("loja");
        try {
            String status = request.getParameter("status");
            if (status.equalsIgnoreCase("on")) {
                usuario.setStatus(1);
            } else {
                usuario.setStatus(0);
            }
        } catch (Exception e) {
            usuario.setStatus(0);
        }

        try {
            usuario.setId(Integer.parseInt(id));
            usuario.setIdPermissao(Integer.parseInt(idPermissao));
            usuario.setIdLoja(Integer.parseInt(idLoja));
        } catch (Exception e) {
            return "usuario-editar.jsp";
        }

        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setDataNascimento(nascimento);
        usuario.setSexo(sexo);
        usuario.setTelefone(telefone);
        usuario.setCelular(celular);
        usuario.setEmail(email);
        usuario.setCep(cep);
        usuario.setLogradouro(logradouro);
        usuario.setNumero(numero);
        usuario.setBairro(bairro);
        usuario.setCidade(cidade);
        usuario.setComplemento(complemento);
        usuario.setEstado(estado);

        usuario.setNomeUsuario(NomeUsuario);
        usuario.setSenha(senha);

        if (usuarioValido(usuario)) {
            DaoUsuario dao = new DaoUsuario();
            dao.editar(usuario);
        }

        return "usuarios.jsp";
    }

    public boolean usuarioValido(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        if (usuario.getId() <= 0) {
            return false;
        }
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            System.out.println("Nome com erro");
            return false;
        }
        if (usuario.getCpf() == null || usuario.getCpf().equals("")) {
            System.out.println("cpf com erro");
            return false;
        }
        if (usuario.getSexo() == null || usuario.getSexo().equals("")) {
            System.out.println("sexo com erro");
            return false;
        }
        if (usuario.getTelefone() == null || usuario.getTelefone().equals("")) {
            System.out.println("telefone com erro");
            return false;
        }
        if (usuario.getCep() == null || usuario.getCep().equals("")) {
            System.out.println("cep com erro");
            return false;
        }
        if (usuario.getLogradouro() == null || usuario.getLogradouro().equals("")) {
            System.out.println("logradouro com erro");
            return false;
        }
        if (usuario.getBairro() == null || usuario.getBairro().equals("")) {
            System.out.println("Bairro com erro");
            return false;
        }
        if (usuario.getCidade() == null || usuario.getCidade().equals("")) {
            System.out.println("Cidade com erro");
            return false;
        }
        if (usuario.getEstado() == null || usuario.getEstado().equals("")) {
            System.out.println("Estado com erro");
            return false;
        }
        if (usuario.getNomeUsuario() == null || usuario.getNomeUsuario().equals("")) {
            System.out.println("Nome usuario com erro");
            return false;
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
            System.out.println("senha com erro");
            return false;
        }
        if (usuario.getIdPermissao() <= 0) {
            System.out.println("Id permissao com erro");
            return false;
        }
        if (usuario.getIdLoja() <= 0) {
            System.out.println("Id loja com erro");
            return false;
        }

        return true;
    }
}
