/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica.loja;

import br.onevision.rainhadasucata.dao.DaoLoja;
import br.onevision.rainhadasucata.logica.Logica;
import br.onevision.rainhadasucata.model.Loja;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author everton
 */
public class LojaAdicionar implements Logica {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Loja loja = new Loja();

        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");


        loja.setNome(nome);
        loja.setCnpj(cnpj);
        loja.setTelefone(telefone);
        loja.setEmail(email);
        loja.setCep(cep);
        loja.setLogradouro(logradouro);
        loja.setNumero(numero);
        loja.setBairro(bairro);
        loja.setCidade(cidade);
        loja.setEstado(estado);

        if (lojaValida(loja)) {
            DaoLoja dao = new DaoLoja();
            dao.inserir(loja);
        }

        return "lojas.jsp";
    }

    public boolean lojaValida(Loja loja) {
        if (loja == null) {
            return false;
        }
        if (loja.getNome() == null || loja.getNome().equals("")) {
            System.out.println("Nome com erro");
            return false;
        }

        if (loja.getTelefone() == null || loja.getTelefone().equals("")) {
            System.out.println("telefone com erro");
            return false;
        }
        if (loja.getCep() == null || loja.getCep().equals("")) {
            System.out.println("cep com erro");
            return false;
        }
        if (loja.getLogradouro() == null || loja.getLogradouro().equals("")) {
            System.out.println("logradouro com erro");
            return false;
        }
        if (loja.getBairro() == null || loja.getBairro().equals("")) {
            System.out.println("Bairro com erro");
            return false;
        }
        if (loja.getCidade() == null || loja.getCidade().equals("")) {
            System.out.println("Cidade com erro");
            return false;
        }
        if (loja.getEstado() == null || loja.getEstado().equals("")) {
            System.out.println("Estado com erro");
            return false;
        }
        return true;
    }
}
