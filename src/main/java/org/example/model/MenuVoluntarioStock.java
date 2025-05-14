package org.example.model;

import java.util.Scanner;

public class MenuVoluntarioStock {
    private final VoluntarioStock voluntario;
    private final Federacao federacao;
    private final Scanner sc = new Scanner(System.in);

    public MenuVoluntarioStock(VoluntarioStock voluntario, Federacao federacao) {
        this.voluntario = voluntario;
        this.federacao = federacao;
    }

    public void mostrar() {
        int opcao;
        do {
            System.out.println("\n=== Menu Voluntário de Stock ===");
            System.out.println("1. Ver produtos da barraca");
            System.out.println("2. Repor stock");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    reporStock();
                    break;
                case 3:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
    }

    private void listarProdutos() {
        Barraca barraca = federacao.getBarracaDoVoluntario(voluntario);
        if (barraca == null) {
            System.out.println("Voluntário não está atribuído a nenhuma barraca.");
            return;
        }

        System.out.println("Produtos da barraca " + barraca.getNome() + ":");
        for (Produto produto : barraca.getProdutos()) {
            System.out.println("- " + produto.getNome() + " | Stock: " + produto.getStock());
        }
    }

    private void reporStock() {
        Barraca barraca = federacao.getBarracaDoVoluntario(voluntario);
        if (barraca == null) {
            System.out.println("Voluntário não está atribuído a nenhuma barraca.");
            return;
        }

        listarProdutos();

        System.out.print("Nome do produto a repor: ");
        String nomeProduto = sc.nextLine();

        Produto produtoSelecionado = null;
        for (Produto p : barraca.getProdutos()) {
            if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoSelecionado = p;
                break;
            }
        }

        if (produtoSelecionado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Quantidade a repor: ");
        int quantidade = Integer.parseInt(sc.nextLine());

        produtoSelecionado.reporStock(quantidade);
        barraca.reporStock(quantidade);

        System.out.println("Stock reposto com sucesso.");
    }
}