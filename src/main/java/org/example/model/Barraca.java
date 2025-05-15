package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Barraca implements Classificavel {
    private String nome;
    private String instituicao;
    private List<Produto> produtos;
    private List<Voluntario> voluntarios;
    private List<Escala> escalas;
    private int stockFinalDiario;
    private double vendasTotais;

    public Barraca(String nome, String instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
        this.produtos = new ArrayList<>();
        this.voluntarios = new ArrayList<>();
        this.escalas = new ArrayList<>();
        this.stockFinalDiario = 0;
        this.vendasTotais = 0.0;
    }

    public String getNome() { return nome; }
    public String getInstituicao() { return instituicao; }
    public List<Produto> getProdutos() { return produtos; }
    public List<Voluntario> getVoluntarios() { return voluntarios; }
    public List<Escala> getEscalas() { return escalas; }
    public double getVendasTotais() { return vendasTotais; }

    public boolean adicionarProduto(Produto produto) {
        return produtos.add(produto);
    }

    public boolean adicionarVoluntario(Voluntario voluntario) {
        if (voluntario.getInstituicao().equals(instituicao)) {
            return voluntarios.add(voluntario);
        }
        return false;
    }

    public boolean adicionarEscala(Escala escala) {
        for (Voluntario v : escala.getVoluntarios()) {
            for (Barraca b : Federacao.getInstance().getBarracas()) {
                if (!b.equals(this)) {
                    for (Escala e : b.getEscalas()) {
                        if (e.getDia().equals(escala.getDia()) && e.getVoluntarios().contains(v)) {
                            return false;
                        }
                    }
                }
            }
        }
        return escalas.add(escala);
    }

    public void registrarVenda(double valor, Voluntario voluntario) {
        this.vendasTotais += valor;
        if (voluntario.getTipo().equals("VENDAS")) {
            voluntario.setVendasDiarias(voluntario.getVendasDiarias() + valor);
        }
    }

    public void atualizarStockFinalDiario() {
        this.stockFinalDiario = produtos.stream().mapToInt(Produto::getStock).sum();
    }

    public int getStockFinalDiario() { return stockFinalDiario; }

    @Override
    public String calcularClassificacao() {
        atualizarStockFinalDiario();
        if (stockFinalDiario > 100) {
            return "Bronze";
        } else if (stockFinalDiario >= 50) {
            return "Prata";
        } else {
            return "Ouro";
        }
    }

    @Override
    public String toString() {
        return "Barraca: " + nome + " (" + instituicao + ", Classificação: " + calcularClassificacao()+")";

    }
}