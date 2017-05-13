package br.onevision.rainhadasucata.servlet;

import br.onevision.rainhadasucata.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio.jrezequiel
 */
@WebServlet(name = "ServletUsuarioCadastrar", urlPatterns = {"/usuario-cadastro"})
public class ServletUsuarioCadastrar extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario user = new Usuario();

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String dataNasc = request.getParameter("data-nascimento");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String status = request.getParameter("status");
        String permissao = request.getParameter("permissao");

        //VERIFICA SE O STATUS 0 | 1
        try {
            if (status.equalsIgnoreCase("false")) {
                user.setStatus(false);
            } else if (status.equalsIgnoreCase("true")) {
                user.setStatus(true);
            }
        } catch (Exception e) {
        }

        //VERIFICA QUAL PERMISSAO O USUARIO POSSUI
        try {
            if (permissao.equalsIgnoreCase("1")) {
                user.setIdPermissao(1);
            } else if (permissao.equalsIgnoreCase("2")) {
                user.setIdPermissao(2);
            } else if (permissao.equalsIgnoreCase("3")) {
                user.setIdPermissao(3);
            }
            }catch (Exception e) {
        }
        
            user.setNome(nome);
            user.setCpfCnpj(cpf);
            //arrumar a verificacao da data de nascimento
            //user.setDataNascimento(dataNasc);
            user.setSexo(sexo);
            user.setTelefone(telefone);
            user.setCelular(celular);
            user.setEmail(email);
            user.setNomeUsuario(usuario);
            user.setSenha(senha);
            //pegar nivel de permissão

            System.out.println(nome);
            System.out.println(cpf);
            System.out.println(telefone);
            System.out.println(celular);
            System.out.println(email);
            System.out.println(usuario);
            System.out.println(senha);
            System.out.println(status);
            System.out.println(permissao);
            System.out.println("NOME = " + user.getNome());
            System.out.println("CPF = " + user.getCpfCnpj());
            System.out.println("SEXO = " + user.getSexo());
            System.out.println("TEL = " + user.getTelefone());
            System.out.println("CEL = " + user.getCelular());
            System.out.println("EMAIL = " + user.getEmail());
            System.out.println("USUARIO = " + user.getNomeUsuario());
            System.out.println("SENHA = " + user.getSenha());
            System.out.println("STATUS = " + user.getStatus());
            System.out.println("PERMISSÃO = " + user.getIdPermissao());

        }

    }
