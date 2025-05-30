package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class MenuBarraca {
    private Scanner scanner;

    public MenuBarraca() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Gerir Barracas ===");
            System.out.println("1. Adicionar Barraca");
            System.out.println("2. Listar Barracas");
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
                    System.out.print("Nome da barraca: ");
                    String nome = scanner.nextLine();
                    System.out.print("Instituição associada: ");
                    String instituicao = scanner.nextLine();
                    Barraca barraca = new Barraca(nome, instituicao);
                    Federacao.getInstance().adicionarBarraca(barraca);
                    System.out.println("Barraca adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("\n=== Lista de Barracas ===");
                    List<Barraca> barracas = Federacao.getInstance().getBarracas();
                    if (barracas.isEmpty()) {
                        System.out.println("Nenhuma barraca registrada.");
                    } else {
                        barracas.forEach(b -> System.out.println("Barraca: " + b.getNome() + " (" + b.getInstituicao() + ")"));
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
