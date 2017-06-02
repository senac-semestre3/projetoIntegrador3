/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.cliente;

import br.onevision.rainhadasucata.dao.DaoCliente;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Cliente;
import br.onevision.rainhadasucata.model.Conversao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class ClienteAdicionar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Conversao conversao = new Conversao();
        Cliente cliente = new Cliente();

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

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(nascimento);
        cliente.setSexo(sexo);
        cliente.setTelefone(telefone);
        cliente.setCelular(celular);
        cliente.setEmail(email);
        cliente.setCep(cep);
        cliente.setLogradouro(logradouro);
        cliente.setNumero(numero);
        cliente.setBairro(bairro);
        cliente.setCidade(cidade);
        cliente.setComplemento(complemento);
        cliente.setEstado(estado);

        if (clienteValido(cliente)) {
            DaoCliente dao = new DaoCliente();
            dao.inserir(cliente);
        }

        return "clientes.jsp";
    }

    public boolean clienteValido(Cliente cliente) {
        if (cliente == null) {
            return false;
        }
        if (cliente.getNome() == null || cliente.getNome().equals("")) {
            System.out.println("Nome com erro");
            return false;
        }
        if (cliente.getCpf() == null || cliente.getCpf().equals("")) {
            System.out.println("cpf com erro");
            return false;
        }
        if (cliente.getSexo() == null || cliente.getSexo().equals("")) {
            System.out.println("sexo com erro");
            return false;
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().equals("")) {
            System.out.println("telefone com erro");
            return false;
        }
        if (cliente.getCep() == null || cliente.getCep().equals("")) {
            System.out.println("cep com erro");
            return false;
        }
        if (cliente.getLogradouro() == null || cliente.getLogradouro().equals("")) {
            System.out.println("logradouro com erro");
            return false;
        }
        if (cliente.getBairro() == null || cliente.getBairro().equals("")) {
            System.out.println("Bairro com erro");
            return false;
        }
        if (cliente.getCidade() == null || cliente.getCidade().equals("")) {
            System.out.println("Cidade com erro");
            return false;
        }
        if (cliente.getEstado() == null || cliente.getEstado().equals("")) {
            System.out.println("Estado com erro");
            return false;
        }
        return true;
    }
}
