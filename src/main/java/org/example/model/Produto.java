package org.example.model;

public class Produto {
    private final String nome;
    private int stock;

    public Produto(String nome, int stock) {
        this.nome = nome;
        this.stock = stock;
    }

    public String getNome() {
        return nome;
    }

    public int getStock() {
        return stock;
    }

    public void adicionar(int quantidade) {
        this.stock += quantidade;
    }

    public boolean vender(int quantidade) {
        if (stock >= quantidade) {
            stock -= quantidade;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nome + ": " + stock;
    }
}
