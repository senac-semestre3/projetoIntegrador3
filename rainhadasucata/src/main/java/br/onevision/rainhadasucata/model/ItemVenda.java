/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.model;

/**
 *
 * @author everton
 */
public class ItemVenda {
    private Produto produto;
    private int quantidade;
    private double subtotal;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
    /**
     * 
     * @param quantidade int
     */
    public void setQuantidade(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = quantidade;
        }else{
            this.quantidade = 0;
        }
    }
    
    
    

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public double calculaSubtotal(){
        if (quantidade > 0) {
            return produto.getPrecoVenda() * quantidade;
        }else{
            return 0;
        }
    } 
}
