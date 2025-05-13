package org.example.model;

import java.util.*;

public class Barraca {
    private final String nome;
    private final Instituicao instituicao;
    private final List<Voluntario> voluntarios = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>();

    public Barraca(String nome, Instituicao instituicao) {
        this.nome = nome;
        this.instituicao = instituicao;
    }

    public void adicionarProduto(Produto p) {
        produtos.add(p);
    }

    public void adicionarVoluntario(Voluntario v) {
        voluntarios.add(v);
    }

    public void mostrarDetalhes() {
        System.out.println("--- Barraca: \"" + nome + "\" ---");
        System.out.println("Instituição: " + instituicao.getNome());
        System.out.println("Voluntários:");
        for (Voluntario v : voluntarios) {
            System.out.println("- " + v);
        }
        System.out.println("Stock:");
        for (Produto p : produtos) {
            System.out.println("- " + p);
        }
    }

    public boolean temVoluntario(String nome) {
        return voluntarios.stream().anyMatch(v -> v.getNome().equalsIgnoreCase(nome));
    }

    public void mostrarVendas() {
        // Stub - simulação
        System.out.println("[Vendas de produtos desta barraca...]");
    }

    public void venderProduto(String produto, int qtd) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(produto)) {
                if (p.vender(qtd)) {
                    System.out.println("Venda registada com sucesso.");
                } else {
                    System.out.println("Stock insuficiente.");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void reporStock(Scanner scanner) {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(i + ": " + produtos.get(i));
        }
        System.out.print("Escolha produto: ");
        int idx = scanner.nextInt();
        System.out.print("Quantidade: ");
        int qtd = scanner.nextInt();
        produtos.get(idx).adicionar(qtd);
        System.out.println("Reposição feita.");
    }

    public void verProdutos() {
        produtos.forEach(System.out::println);
    }
}
