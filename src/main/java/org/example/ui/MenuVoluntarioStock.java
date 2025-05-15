package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Produto;
import org.example.model.Voluntario;

import java.util.Scanner;

class MenuVoluntarioStock {
    private Scanner scanner;
    private Voluntario voluntario;
    private Barraca barraca;

    public MenuVoluntarioStock(Voluntario voluntario, Barraca barraca) {
        this.scanner = new Scanner(System.in);
        this.voluntario = voluntario;
        this.barraca = barraca;
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Menu Voluntário de Stock (" + voluntario.getNome() + ") ===");
            System.out.println("1. Ver Stock");
            System.out.println("2. Repor Stock");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Stock da Barraca " + barraca.getNome() + " ===");
                    barraca.getProdutos().forEach(p -> System.out.println(p.toString()));
                    barraca.atualizarStockFinalDiario();
                    System.out.println("Stock Total: " + barraca.getStockFinalDiario());
                    System.out.println("Classificação da Barraca: " + barraca.calcularClassificacao());
                    break;
                case 2:
                    System.out.println("Produtos disponíveis:");
                    barraca.getProdutos().forEach(p -> System.out.println("- " + p.getNome()));
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    Produto produto = barraca.getProdutos().stream()
                            .filter(p -> p.getNome().equals(nomeProduto))
                            .findFirst()
                            .orElse(null);

                    if (produto == null) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    System.out.print("Quantidade a repor: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }
                    produto.reporStock(quantidade);
                    System.out.println("Stock reposto com sucesso!");
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}