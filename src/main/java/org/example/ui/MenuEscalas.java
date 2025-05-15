package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Escala;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.time.LocalDate;
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
            int opcao = scanner.nextInt();
            scanner.nextLine();

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

                    System.out.print("Dia (YYYY-MM-DD): ");
                    LocalDate dia;
                    try {
                        dia = LocalDate.parse(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Formato de data inválido!");
                        break;
                    }
                    Escala escala = new Escala(dia);

                    System.out.println("Adicionar voluntários (mínimo 2):");
                    for (int i = 0; i < 2; i++) {
                        System.out.print("Nome do voluntário: ");
                        String nomeVoluntario = scanner.nextLine();
                        Voluntario voluntario = barraca.getVoluntarios().stream()
                                .filter(v -> v.getNome().equals(nomeVoluntario))
                                .findFirst()
                                .orElse(null);

                        if (voluntario != null) {
                            escala.adicionarVoluntario(voluntario);
                        } else {
                            System.out.println("Voluntário não encontrado!");
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
                    barraca.getEscalas().forEach(e -> System.out.println(e.toString()));
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}