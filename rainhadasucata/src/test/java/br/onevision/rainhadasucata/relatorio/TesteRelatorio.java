/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.relatorio;

import br.onevision.rainhadasucata.dao.DaoRelatorio;
import br.onevision.rainhadasucata.model.Relatorio;
import java.util.List;

/**
 *
 * @author everton
 */
public class TesteRelatorio {
    public static void main(String[] args) throws Exception {
        
        DaoRelatorio dao = new DaoRelatorio();
        
        List<Relatorio> relatorios = dao.listarPorCliente("Maria");

        System.out.println(relatorios.size());
      //  for (Relatorio relatorio : relatorios) {
        for (int i = 0; i < relatorios.size(); i++) {
            Relatorio relatorio = new Relatorio();
        
            //System.out.println("Id da Venda: " + relatorio.getIdVenda());
           // System.out.println("Nome Cliente: " + relatorio.getCliente().getNome());
            
            for (int j = 0; j < relatorios.get(i).getItens().size(); j++) {
                System.out.println("Produto: " + relatorios.get(j).getItens().get(j).getProduto().getNome());
            }
        }
        
        
    }
}
