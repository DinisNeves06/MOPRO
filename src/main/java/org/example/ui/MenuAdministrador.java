package org.example.ui;

import org.example.model.Federacao;
import java.util.Scanner;

public class MenuAdministrador {
    private final Scanner scanner;
    private final Federacao federacao;

    public MenuAdministrador(Scanner scanner, Federacao federacao) {
        this.scanner = scanner;
        this.federacao = federacao;
    }

    public void mostrar() {
        while (true) {
            System.out.println("===== Menu do Administrador =====");
            System.out.println("1. Ver barracas com detalhes (instituição, recursos humanos, stock)");
            System.out.println("2. Classificação de barracas e voluntários de vendas");
            System.out.println("3. Listar voluntários por número de aluno");
            System.out.println("4. Listar vendas por barraca e categoria");
            System.out.println("5. Gravar dados em ficheiro");
            System.out.println("6. Carregar dados de ficheiro");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> federacao.mostrarDetalhesBarracas();
                case 2 -> federacao.listarBarracasPorVendas();
                case 3 -> federacao.listarVoluntariosOrdenados();
                case 4 -> federacao.listarVendasPorCategoria();
                case 5 -> federacao.gravarDados();
                case 6 -> federacao.carregarDados();
                case 7 -> {
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
