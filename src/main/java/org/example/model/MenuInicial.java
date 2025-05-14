package menu;

import model.*;

import java.util.Scanner;

public class MenuInicial {
    private Federacao federacao;
    private Scanner scanner;

    public MenuInicial(Federacao federacao) {
        this.federacao = federacao;
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        int opcao = -1;
        do {
            System.out.println("\n===== SISTEMA FAP - GESTÃO DE BARRACAS =====");
            System.out.println("1. Entrar como Administrador");
            System.out.println("2. Entrar como Voluntário de Vendas");
            System.out.println("3. Entrar como Voluntário de Stock");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        loginAdministrador();
                        break;
                    case 2:
                        loginVoluntario(VoluntarioVendas.class);
                        break;
                    case 3:
                        loginVoluntario(VoluntarioStock.class);
                        break;
                    case 4:
                        System.out.println("A sair... Até breve!");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        } while (opcao != 4);
    }

    private void loginAdministrador() {
        System.out.println("\n--- Login Administrador ---");
        String nome = pedir("Nome: ");
        int numero = Integer.parseInt(pedir("Número de aluno: "));
        String curso = pedir("Curso: ");
        String instituicao = pedir("Instituição: ");
        String password = pedir("Password: ");

        Administrador admin = federacao.autenticarAdministrador(nome, numero, curso, instituicao, password);
        if (admin != null) {
            System.out.println("Login efetuado com sucesso como Administrador.");
            new MenuAdministrador(federacao, admin).mostrar();
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    private void loginVoluntario(Class<?> tipo) {
        System.out.println("\n--- Login Voluntário (" + tipo.getSimpleName() + ") ---");
        String nome = pedir("Nome: ");
        int numero = Integer.parseInt(pedir("Número de aluno: "));
        String curso = pedir("Curso: ");
        String instituicao = pedir("Instituição: ");
        String password = pedir("Password: ");

        Voluntario v = federacao.autenticarVoluntario(nome, numero, curso, instituicao, password, tipo);
        if (v != null) {
            System.out.println("Login efetuado com sucesso como " + tipo.getSimpleName() + ".");
            if (v instanceof VoluntarioVendas) {
                new MenuVoluntarioVendas(federacao, (VoluntarioVendas) v).mostrar();
            } else if (v instanceof VoluntarioStock) {
                new MenuVoluntarioStock(federacao, (VoluntarioStock) v).mostrar();
            }
        } else {
            System.out.println("Credenciais inválidas.");
        }
    }

    private String pedir(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
