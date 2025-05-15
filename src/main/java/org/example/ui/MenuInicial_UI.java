package org.example.ui;

import org.example.model.Administrador;
import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        System.out.print("Número do aluno: ");
        String numeroAluno = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("Instituição: ");
        String instituicao = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Administrador admin = Federacao.getInstance().getAdministrador();
        if (admin == null) {
            System.out.println("Erro: Nenhum administrador configurado!");
            return;
        }
        if (admin.autenticar(nome, numeroAluno, curso, instituicao, password)) {
            System.out.println("Autenticação bem-sucedida! Bem-vindo, " + admin.getNome());
            new MenuAdministrador().mostrar();
        } else {
            System.out.println("Autenticação falhou! Verifique os dados inseridos.");
        }
    }

    private void autenticarVoluntario(String tipo) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Número do aluno: ");
        String numeroAluno = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.print("Instituição: ");
        String instituicao = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Barraca barraca = Federacao.getInstance().getBarracas().stream()
                .filter(b -> b.getVoluntarios().stream()
                        .anyMatch(v -> v.getNome().equals(nome)))
                .findFirst()
                .orElse(null);

        if (barraca == null) {
            System.out.println("Erro: Voluntário não encontrado em nenhuma barraca!");
            return;
        }

        Voluntario voluntario = barraca.getVoluntarios().stream()
                .filter(v -> v.autenticar(nome, numeroAluno, curso, instituicao, password))
                .findFirst()
                .orElse(null);

        if (voluntario == null) {
            System.out.println("Erro: Credenciais inválidas!");
            return;
        }

        if (!voluntario.getTipo().equals(tipo)) {
            System.out.println("Erro: Voluntário é do tipo " + voluntario.getTipo() + ", não " + tipo + "!");
            return;
        }

        System.out.println("Autenticação bem-sucedida! Bem-vindo, " + voluntario.getNome());
        if (tipo.equals("VENDAS")) {
            new MenuVoluntarioVendas(voluntario, barraca).mostrar();
        } else {
            new MenuVoluntarioStock(voluntario, barraca).mostrar();
        }
    }
}