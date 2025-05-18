package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Escala;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class MenuEscalas {
    private Scanner scanner;

    public MenuEscalas() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        while (true) {
            System.out.println("\n=== Gerir Escalas ===");
            System.out.println("1. Adicionar Escala");
            System.out.println("2. Listar Escalas de uma Barraca");
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

                    System.out.print("Dia (ANO-MES-DIA): ");
                    LocalDate dia;
                    try {
                        dia = LocalDate.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Formato de data inválido! Use ANO-MES-DIA.");
                        break;
                    }
                    Escala escala = new Escala(dia);

                    System.out.println("Adicionar voluntários (mínimo 2):");
                    for (int i = 0; i < 2; i++) {
                        System.out.print("Nome do voluntário " + (i + 1) + ": ");
                        String nomeVoluntario = scanner.nextLine();
                        Voluntario voluntario = barraca.getVoluntarios().stream()
                                .filter(v -> v.getNome().equals(nomeVoluntario))
                                .findFirst()
                                .orElse(null);

                        if (voluntario != null) {
                            if (escala.adicionarVoluntario(voluntario)) {
                                System.out.println("Voluntário '" + nomeVoluntario + "' adicionado à escala.");
                            } else {
                                System.out.println("Erro: Não foi possível adicionar o voluntário à escala (limite atingido).");
                                i--;
                            }
                        } else {
                            System.out.println("Voluntário '" + nomeVoluntario + "' não encontrado na barraca!");
                            i--;
                        }
                    }

                    if (barraca.adicionarEscala(escala)) {
                        System.out.println("Escala adicionada com sucesso!");
                    } else {
                        System.out.println("Erro: Um ou mais voluntários já estão escalados noutra barraca neste dia!");
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

                    System.out.println("\n=== Escalas da Barraca " + nomeBarraca + " ===");
                    List<Escala> escalas = barraca.getEscalas();
                    if (escalas.isEmpty()) {
                        System.out.println("Nenhuma escala registrada para esta barraca.");
                    } else {
                        escalas.forEach(e -> System.out.println(e.toString()));
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