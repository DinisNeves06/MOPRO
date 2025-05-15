package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class MenuVoluntarios {
    private Scanner scanner;

    public MenuVoluntarios() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Gerir Voluntários ===");
            System.out.println("1. Adicionar Voluntário");
            System.out.println("2. Listar Voluntários de uma Barraca");
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
                    String nomeBarraca = scanner.nextLine();
                    Barraca barraca = Federacao.getInstance().getBarracas().stream()
                            .filter(b -> b.getNome().equals(nomeBarraca))
                            .findFirst()
                            .orElse(null);

                    if (barraca == null) {
                        System.out.println("Barraca não encontrada!");
                        break;
                    }

                    System.out.print("Nome do voluntário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Número do aluno: ");
                    String numeroAluno = scanner.nextLine();
                    System.out.print("Curso: ");
                    String curso = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Tipo (VENDAS/STOCK): ");
                    String tipo = scanner.nextLine().toUpperCase();

                    try {
                        Voluntario voluntario = new Voluntario(nome, numeroAluno, curso, barraca.getInstituicao(), password, tipo);
                        if (barraca.adicionarVoluntario(voluntario)) {
                            System.out.println("Voluntário '" + nome + "' (" + tipo + ") adicionado com sucesso à barraca '" + nomeBarraca + "'!");
                        } else {
                            System.out.println("Erro ao adicionar voluntário!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Nome da barraca: ");
                    nomeBarraca = scanner.nextLine();
                    barraca = Federacao.getInstance().getBarracas().stream()
                            .filter(b -> b.getNome().equals(nomeBarraca))
                            .findFirst()
                            .orElse(null);

                    if (barraca == null) {
                        System.out.println("Barraca não encontrada!");
                        break;
                    }

                    System.out.println("\n=== Voluntários da Barraca " + nomeBarraca + " ===");
                    List<Voluntario> voluntarios = barraca.getVoluntarios();
                    if (voluntarios.isEmpty()) {
                        System.out.println("Nenhum voluntário registrado nesta barraca.");
                    } else {
                        voluntarios.forEach(v -> System.out.println("Voluntário: " + v.getNome() + " (" + v.getNumeroAluno() + ", " + v.getCurso() + ", " + v.getTipo() + ", " + v.getInstituicao() + ")"));
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