/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.service;

import br.onevision.rainhadasucata.dao.DaoProduto;
import br.onevision.rainhadasucata.model.Produto;
import java.sql.SQLException;

/**
 *
 * @author DANILO&PAULA
 */
public class ServiceProdutoCadastrar {
    
    public ServiceProdutoCadastrar() {
    }

    public boolean inserirProduto(Produto produto) throws RuntimeException, SQLException {
//
        if (produto == null) {
            return false;
        } else {
            if (produto.getNome() == null || produto.getNome().equals("")) {
                return false;
            } else if (produto.getMarca() == null || produto.getMarca().equals("")) {
                return false;
            } else if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
                return false;
            }else if(produto.getPrecoCompra()  <= 0 || "".equals(produto.getPrecoCompra())){
            return false;
            
            }else if(produto.getMargemVenda()<= 0 || "".equals(produto.getMargemVenda()))
            return false;
//              }else if(produto.getPrecoVenda()) {
//            return false;
//              }else if(produto.getEstoque()<= 0 || "".equals(produto.getEstoque()) {
//            return false;
//              }else if(produto.getEstoqueMinimo()<= 0 || "".equals(produto.getEstoqueMinimo()) {
//            return false;
//              }else  if(produto.isStatus() == false)) {
//            return false;
        }
        
 
     
      
            
            

            try {
                DaoProduto daop = new DaoProduto();

                daop.inserir(produto);

            } catch (RuntimeException | SQLException e) {
            }

            return true;
        }
    }
//}
