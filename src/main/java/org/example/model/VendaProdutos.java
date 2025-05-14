package org.example.model;

public class VendaProdutos {
    private Produto produto;
    private int quantidade;

    public VendaProdutos(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + ", Quantidade: " + quantidade;
    }
}