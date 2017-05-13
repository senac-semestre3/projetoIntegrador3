package br.onevision.rainhadasucata.service;

import br.onevision.rainhadasucata.dao.DaoUsuario;
import br.onevision.rainhadasucata.model.Usuario;

/**
 *
 * @author fabio.jrezequiel
 */
public class ServiceUsuarioCadastrar {

    public static boolean inserirUsuario(Usuario user) {
        if (user == null) {
            return false;
        }
        if (user.getNome() == null || user.getNome().equals("")) {
            return false;
        }
        if (user.getCpfCnpj() == null || user.getCpfCnpj().equals("")) {
            return false;
        }
        if (user.getSexo() == null || user.getSexo().equals("")) {
            return false;
        }
        if (user.getTelefone() == null || user.getTelefone().equals("")) {
            return false;
        }
        if (user.getCelular() == null || user.getCelular().equals("")) {
            return false;
        }
        if (user.getEmail() == null || user.getEmail().equals("")) {
            return false;
        }
        if (user.getNomeUsuario() == null || user.getNomeUsuario().equals("")) {
            return false;
        }
        if (user.getSenha() == null || user.getSenha().equals("")) {
            return false;
        }
        if (user.getStatus() != false || user.getStatus() != true) {
            return false;
        }
        if (user.getIdPermissao() < 1) {
            return false;
        }
        try {
            DaoUsuario dao = new DaoUsuario();
            dao.inserir(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
