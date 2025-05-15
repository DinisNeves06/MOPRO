package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Produto;
import org.example.model.Voluntario;

import java.util.InputMismatchException;
import java.util.List;
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

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Stock da Barraca " + barraca.getNome() + " ===");
                    List<Produto> produtos = barraca.getProdutos();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto registrado.");
                    } else {
                        produtos.forEach(p -> System.out.println(p.toString()));
                    }
                    barraca.atualizarStockFinalDiario();
                    System.out.println("Stock Total: " + barraca.getStockFinalDiario());
                    System.out.println("Classificação da Barraca: " + barraca.calcularClassificacao());
                    break;
                case 2:
                    produtos = barraca.getProdutos();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto registrado na barraca!");
                        break;
                    }
                    System.out.println("Produtos disponíveis:");
                    produtos.forEach(p -> System.out.println("- " + p.getNome()));
                    System.out.print("Nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    Produto produto = produtos.stream()
                            .filter(p -> p.getNome().equals(nomeProduto))
                            .findFirst()
                            .orElse(null);

                    if (produto == null) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    System.out.print("Quantidade a repor: ");
                    int quantidade;
                    try {
                        quantidade = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Quantidade inválida! Insira um número.");
                        scanner.nextLine();
                        break;
                    }
                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida! Deve ser maior que zero.");
                        break;
                    }
                    produto.reporStock(quantidade);
                    System.out.println("Stock reposto com sucesso! Novo stock: " + produto.getStock());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}