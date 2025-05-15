package org.example.ui;

import org.example.model.Administrador;
import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.time.LocalDate;
import java.util.*;

// Classe para Menu Inicial
class MenuInicial_UI {
    private Scanner scanner;

    public MenuInicial_UI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Sistema de Gestão do Queimódromo ===");
            System.out.println("1. Entrar como Administrador");
            System.out.println("2. Entrar como Voluntário de Vendas");
            System.out.println("3. Entrar como Voluntário de Stock");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    autenticarAdministrador();
                    break;
                case 2:
                    autenticarVoluntario("VENDAS");
                    break;
                case 3:
                    autenticarVoluntario("STOCK");
                    break;
                case 4:
                    System.out.println("A sair...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void autenticarAdministrador() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Administrador admin = Federacao.getInstance().getAdministrador();
        if (admin.autenticar(nome, password)) {
            new MenuAdministrador().mostrar();
        } else {
            System.out.println("Autenticação falhou! Verifique o nome e a password.");
        }
    }

    private void autenticarVoluntario(String tipo) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Barraca barraca = Federacao.getInstance().getBarracas().stream()
                .filter(b -> b.getVoluntarios().stream()
                        .anyMatch(v -> v.autenticar(nome, password) && v.getTipo().equals(tipo)))
                .findFirst()
                .orElse(null);

        if (barraca != null) {
            Voluntario voluntario = barraca.getVoluntarios().stream()
                    .filter(v -> v.autenticar(nome, password))
                    .findFirst()
                    .orElse(null);
            if (tipo.equals("VENDAS")) {
                new MenuVoluntarioVendas(voluntario, barraca).mostrar();
            } else {
                new MenuVoluntarioStock(voluntario, barraca).mostrar();
            }
        } else {
            System.out.println("Autenticação falhou ou voluntário não é do tipo " + tipo + "!");

        }
    }
}