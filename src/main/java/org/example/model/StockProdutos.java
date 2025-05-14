package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class StockProdutos {
    private List<StockDisponivel> stock;

    public StockProdutos() {
        this.stock = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        StockDisponivel item = encontrarItem(produto);
        if (item != null) {
            item.adicionarQuantidade(quantidade);
        } else {
            stock.add(new StockDisponivel(produto, quantidade));
        }
    }

    public boolean temStockSuficiente(VendaProdutos venda) {
        StockDisponivel item = encontrarItem(venda.getProduto());
        return item != null && item.getQuantidade() >= venda.getQuantidade();
    }

    public boolean retirarStock(VendaProdutos venda) {
        if (!temStockSuficiente(venda)) {
            return false;
        }
        StockDisponivel item = encontrarItem(venda.getProduto());
        item.removerQuantidade(venda.getQuantidade());
        return true;
    }

    public int consultarStock(Produto produto) {
        StockDisponivel item = encontrarItem(produto);
        return item != null ? item.getQuantidade() : 0;
    }

    public void mostrarStock() {
        System.out.println("Stock atual:");
        for (StockDisponivel item : stock) {
            System.out.println(item.getProduto().getNome() + " - Quantidade: " + item.getQuantidade());
        }
    }

    private StockDisponivel encontrarItem(Produto produto) {
        for (StockDisponivel item : stock) {
            if (item.getProduto().equals(produto)) {
                return item;
            }
        }
        return null;
    }

    public int getQuantidade() {
        return 0;
    }

    public void setQuantidade(int i) {
    }
}