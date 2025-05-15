package org.example.ui;

import java.util.Scanner;

class MenuAdministrador {
    private Scanner scanner;

    public MenuAdministrador() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Gerir Barracas");
            System.out.println("2. Gerir Produtos");
            System.out.println("3. Gerir Voluntários");
            System.out.println("4. Gerir Escalas");
            System.out.println("5. Ver Instituições Associadas");
            System.out.println("6. Ver Classificação");
            System.out.println("7. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    new MenuBarraca().mostrar();
                    break;
                case 2:
                    new RegistarProduto_UI().mostrar();
                    break;
                case 3:
                    new MenuVoluntarios().mostrar();
                    break;
                case 4:
                    new MenuEscalas().mostrar();
                    break;
                case 5:
                    new MenuInstituicoes().mostrar();
                    break;
                case 6:
                    new MenuClassificacao().mostrar();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }

        }
    }
}