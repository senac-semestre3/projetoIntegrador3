/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.logica;

import br.onevision.rainhadasucata.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Willian Vieira //
 */
//@WebFilter(filterName = "AutorizacaoFilter",
//        servletNames
//        = {"ServletClienteCadastrar", "ServletClienteVer", "ServletListarClientes", "ServletListarProdutos",
//            "ServletListarUsuarios", "ServletProdutoVer", "ServletUsuarioCadastrar",
//            "ServletUsuarioVer", "SevletProdutoCadastrar", "ClienteAdicionar"})
@WebFilter(filterName = "AutorizacaoFilter",
        servletNames
        = {"CarrinhoController", "ClienteController", "LoginController", "LojaController", "ProdutoController", 
            "UsuarioController", "UsuarioController",})

public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
        // A) CAST DOS PARAMETROS RECEBIDOS
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String pagina = httpRequest.getRequestURI();
        System.out.println("Imprimindo pagina "+ pagina);
        
        
        
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // B) TENTA RECUPERAR A SESS�O DO USU�RIO
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("sessionusuario");
        // 2) NA LOGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUARIO SIGNIFICA
        // QUE USUARIO ESTA LOGADO
        // CASO CONTRARIO, REDIRECIONA PARA TELA DE LOGIN
        if (usuario == null) {
            httpResponse.sendRedirect("login.jsp");
            return;
        }

        //Manda de volta para a servlet espec�fica
        chain.doFilter(request, response);

// 
// try {
// // 3) VERIFICAR SE USUARIO PODE ACESSAR PAGINA
// if (verificarAcesso(usuario, httpRequest, httpResponse)) {
// // CHAMADA QUE ENVIA A REQUISIAO PARA O PROXIMO FILTRO OU SERVLET
// chain.doFilter(request, response);
// } else {
// // SE NAO PODER ACESSAR, APRESENTA ERRO
// httpResponse.sendRedirect("erroNaoAutorizado.jsp");
// }
// } catch (Throwable t) {
// t.printStackTrace();
// }
    }

    /**
     * ROTINA PARA DESTRUIU DO FILTRO
     */
    @Override
    public void destroy() {

    }

    /**
     * ROTINA DE INICIALIZACAO DO FILTRO
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }

    private boolean verificarAcesso(Usuario usuario, HttpServletRequest req,
            HttpServletResponse resp) {
        String pagina = req.getRequestURI();  // URL com final X - > listar-cliente 

        // se no final da chamada da requisito conter o nome da servlet fazer a:
        if (pagina.endsWith("listar-cliente ou qualquer outra") && usuario.getId() == 1) {
            return true;
        } else if (pagina.endsWith("IncluirPessoaServlet")
                && usuario.getIdPermissao() == 2) {
            return true;
        }
        return false;
    }
}
