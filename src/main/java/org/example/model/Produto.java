package org.example.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double preco;
    private int stock;

    public Produto(String nome, double preco, int stock) {
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public void reporStock(int quantidade) {
        this.stock += quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " (Preço: €" + preco + ", Stock: " + stock + ")";
    }
}
