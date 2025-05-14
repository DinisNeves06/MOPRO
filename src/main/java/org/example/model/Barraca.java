package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Barraca {

    private String nome;
    private final List<Voluntario> voluntarios;
    private Instituição instituição;
    private final List<StockProdutos> stock;

    public Barraca (String nome, Instituição instituição){

        this.nome = nome;
        this.instituição = instituição;
        this.voluntarios = new ArrayList<>();
        this.stock = new ArrayList<>();

    }


    public String getNome() {
        return nome;
    }

    public Instituição getInstituição() {
        return instituição;
    }

    public List<Voluntario> getVoluntarios() {
        return voluntarios;
    }

    public List<StockProdutos> getStock() {
        return stock;
    }

    public void setStock(List<StockProdutos> stock){
        this.stock = stock;
    }

    public boolean adicionarVoluntario(Voluntario voluntario){
        if (!this.instituição.equals(voluntario.getInstituicao())){
            System.out.println("O voluntário não pertence à instituição da barraca.");
            return false;
        }
        if (voluntario.getBarracaAssociada() != null){
            System.out.println("O voluntário já pertence a outra barraca.");
            return false;
        }

        voluntarios.add(voluntario);
        voluntario.setBarracaAssociada(this);
        return true;
    }

    public void adicionarStock (String nomeProduto, int quantidade){
        for (StockProdutos sp : stock){
            if (sp.getNome().equals(nomeProduto)){
                sp.setQuantidade(sp.getQuantidade() + quantidade);
                System.out.println("Produto " + nomeProduto + "está atualizado no stock");
                return;
            }
        }

        StockProdutos novoProduto = new StockProdutos(nomeProduto, 0, quantidade);
        stock.add(novoProduto);
        System.out.println("Produto " + nomeProduto + "adicionado ao stock");
    }

    public double exportarVendas(){
        double totalVendas = 0.0;

        for (Voluntario v : voluntarios){
            if (v instanceof VoluntarioVendas){
                VoluntarioVendas vv = (VoluntarioVendas) v;
                for (VendaProdutos venda : vv.getTodasVendas()){
                    totalVendas += venda.getValorTotal();

                }
            }
        }

        return totalVendas;
    }

    private int exportarStockTotal(){
        int totalStock = 0;

        for (StockProdutos sp : stock){
            totalStock += sp.getQuantidade();
        }
        return totalStock;
    }

    private int calcularTotalProdutos(){
        int total = 0;
        for (StockProdutos sp : stock){
            total += sp.getQuantidade();
        }
        return total;
    }

    public String classificar(){
        int stockFinal = exportarStockTotal();
        if (stockFinal > 100){
            return "Bronze";
        } else if (stockFinal >= 50 && stockFinal <= 100) {
            return "Prata";

        }else {
            return "Ouro";
        }
    }
}
