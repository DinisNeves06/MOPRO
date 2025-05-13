package org.example;

import org.example.model.Federacao;
import org.example.ui.MenuAdministrador;
import org.example.ui.MenuVoluntarioStock;
import org.example.ui.MenuVoluntarioVenda;

import java.util.Scanner;

public class MenuInicial_UI {
    private final Scanner scanner;
    private final Federacao federacao;

    public MenuInicial_UI(Scanner scanner, Federacao federacao) {
        this.scanner = scanner;
        this.federacao = federacao;
    }

    public void iniciar() {
        while (true) {
            System.out.println("===== Sistema FAP =====");
            System.out.println("1. Administrador");
            System.out.println("2. Voluntário de Vendas");
            System.out.println("3. Voluntário de Stock");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> new MenuAdministrador(scanner, federacao).mostrar();
                case 2 -> new MenuVoluntarioVenda(scanner, federacao).mostrar();
                case 3 -> new MenuVoluntarioStock(scanner, federacao).mostrar();
                case 4 -> {
                    System.out.println("Encerrando...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}