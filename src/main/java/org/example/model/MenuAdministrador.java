package org.example.model;

import java.util.Scanner;

public class MenuAdministrador {
    private final Federacao federacao;
    private final Administrador administrador;
    private final Scanner sc = new Scanner(System.in);
    private final ClassificacaoImpl classificacao = new ClassificacaoImpl();

    public MenuAdministrador(Federacao federacao, Administrador administrador) {
        this.federacao = federacao;
        this.administrador = administrador;
    }

    public void mostrar() {
        int opcao;
        do {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("1. Gerir Barracas");
            System.out.println("2. Gerir Escalas");
            System.out.println("3. Classificação de Barracas e Voluntários");
            System.out.println("4. Listagens Ordenadas");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    gerirBarracas();
                    break;
                case 2:
                    gerirEscalas();
                    break;
                case 3:
                    classificacaoBarracasVoluntarios();
                    break;
                case 4:
                    listagensOrdenadas();
                    break;
                case 5:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private void gerirBarracas() {
        // Gerir barracas (adicionar, listar)
    }

    private void gerirEscalas() {
        // Gerir escalas (associar voluntários a barracas)
    }

    private void classificacaoBarracasVoluntarios() {
        // Classificar barracas e voluntários
    }

    private void listagensOrdenadas() {
        // Listagens ordenadas conforme a especificação
    }
}