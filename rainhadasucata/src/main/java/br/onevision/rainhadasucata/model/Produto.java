/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.onevision.rainhadasucata.model;

import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author everton
 */
public class Produto {
    private int id;
    private String nome;
    private String marca;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    private double margemVenda;
    private int estoque;
    private int estoqueMinimo;
    private int status;
    private boolean deletado;
    
    public Produto(){
        this.deletado = false;
    }
    
    public JSONObject toJSON() throws IOException{
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("nome", this.nome);
        json.put("precoVenda", this.precoVenda);
        json.put("estoque", this.estoque);
        return json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getMargemVenda() {
        return margemVenda;
    }

    public void setMargemVenda(double margemVenda) {
        this.margemVenda = margemVenda;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void setDeletado(boolean deletado) {
        this.deletado = deletado;
    }
    
    
    
}
