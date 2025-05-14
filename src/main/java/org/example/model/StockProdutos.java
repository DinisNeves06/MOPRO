import java.util.ArrayList;
import java.util.List;

public class StockProdutos {
    private List<Produto> produtos;

    public StockProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<StockProdutos> getProdutos() {
        return produtos;
    }

    public int getStockTotal() {
        int total = 0;
        for (StockProdutos p : produtos) {
            total += p.getStock(); // Assumindo que Produto tem getStock()
        }
        return total;
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    // Opcional: remover produto
    public boolean removerProduto(Produto produto) {
        return produtos.remove(produto);
    }

    // Opcional: encontrar produto por nome
    public Produto encontrarProduto(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}