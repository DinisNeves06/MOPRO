package org.example.ui;

import org.example.model.Federacao;
import org.example.model.Barraca;

import java.util.Scanner;

public class MenuVoluntarioStock {
    private final Scanner scanner;
    private final Federacao federacao;

    public MenuVoluntarioStock(Scanner scanner, Federacao federacao) {
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
            System.out.println("===== Menu Voluntário de Stock =====");
            System.out.println("1. Repor stock");
            System.out.println("2. Ver produtos disponíveis");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> barraca.reporStock(scanner);
                case 2 -> barraca.verProdutos();
                case 3 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}


