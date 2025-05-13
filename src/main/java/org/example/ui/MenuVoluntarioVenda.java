package org.example.ui;

import org.example.model.Federacao;
import org.example.model.Barraca;

import java.util.Scanner;

public class MenuVoluntarioVenda {
    private final Scanner scanner;
    private final Federacao federacao;

    public MenuVoluntarioVenda(Scanner scanner, Federacao federacao) {
        this.scanner = scanner;
        this.federacao = federacao;
    }

    public void mostrar() {
        System.out.print("Nome do voluntário: ");
        String nome = scanner.nextLine();
        Barraca barraca = federacao.getBarracaDoVoluntario(nome);
        if (barraca == null) {
            System.out.println("Voluntário não associado a nenhuma barraca.");
            return;
        }

        while (true) {
            System.out.println("===== Menu Voluntário de Vendas =====");
            System.out.println("1. Ver vendas por barraca");
            System.out.println("2. Registar venda");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> barraca.mostrarVendas();
                case 2 -> {
                    System.out.print("Nome do produto: ");
                    String produto = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    barraca.venderProduto(produto, qtd);
                }
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
