package org.example.model;

public class StockDisponivel {
    private Produto produto;
    private int quantidade;

    public StockDisponivel(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int q) {
        this.quantidade += q;
    }

    public void removerQuantidade(int q) {
        if (q <= quantidade) {
            this.quantidade -= q;
        }
    }
}

