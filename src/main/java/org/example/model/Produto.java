package org.example.model;

public class Produto {
    private final String nome;
    private final double preco;
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
        return "Produto: " + nome + " (Preço: €" + preco + ", Stock: " + stock+")";
    }
}