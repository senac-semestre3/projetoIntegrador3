package br.onevision.rainhadasucata.model;

import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author everton
 */
public class ItemVenda {

    private Produto produto;
    private int quantidade;
    private double subtotal;
    
    
    public JSONObject toJSON() throws IOException{
        JSONObject json = new JSONObject();
        json.put("id", this.produto.getId());
        json.put("nome", this.produto.getNome());
        json.put("estoque", this.produto.getEstoque());
        json.put("precoVenda", this.produto.getPrecoVenda());
        json.put("quantidade", this.quantidade);
        json.put("subtotal", this.subtotal);
        return json;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= produto.getEstoque()) {
            if (quantidade > 0) {
                this.quantidade = quantidade;
            } else {
                this.quantidade = 0;
            }
        }
    }

    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal){
        this.subtotal = subtotal;
    }
    public void calculaSubtotal() {
        if (quantidade > 0) {
            this.subtotal = produto.getPrecoVenda() * this.quantidade;
        } else {
            this.subtotal = 0;
        }
    }

}
