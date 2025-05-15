package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Produto;
import org.example.model.Voluntario;

import java.util.Scanner;

class MenuVoluntarioVendas {
    private Scanner scanner;
    private Voluntario voluntario;
    private Barraca barraca;

    public MenuVoluntarioVendas(Voluntario voluntario, Barraca barraca) {
        this.scanner = new Scanner(System.in);
        this.voluntario = voluntario;
        this.barraca = barraca;
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Menu Voluntário de Vendas (" + voluntario.getNome() + ") ===");
            System.out.println("1. Ver Informações de Vendas");
            System.out.println("2. Registrar Venda");
            System.out.println("3. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Informações de Vendas ===");
                    System.out.println("Barraca: " + barraca.getNome());
                    System.out.println("Vendas Totais: €" + barraca.getVendasTotais());
                    System.out.println("Classificação da Barraca: " + barraca.calcularClassificacao());
                    System.out.println("Suas Vendas: €" + voluntario.getVendasDiarias());
                    System.out.println("Sua Classificação: " + voluntario.calcularClassificacao());
                    break;
                case 2:
                    System.out.println("Produtos disponíveis:");
                    barraca.getProdutos().forEach(p -> System.out.println("- " + p.getNome() + " (€" + p.getPreco() + ")"));
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

                    System.out.print("Quantidade vendida: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidade <= 0) {
                        System.out.println("Quantidade inválida!");
                        break;
                    }

                    if (produto.getStock() < quantidade) {
                        System.out.println("Stock insuficiente!");
                        break;
                    }

                    produto.setStock(produto.getStock() - quantidade);
                    double valor = quantidade * produto.getPreco();
                    barraca.registrarVenda(valor, voluntario);
                    System.out.println("Venda registrada com sucesso! Valor: €" + valor);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}