package org.example.ui;

import org.example.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class QueimodromoManagementSystem {
    public static void main(String[] args) {
        try {
            // Inicializar o administrador
            Administrador admin = new Administrador("Antonio", "123", "Medicina", "FMUP", "admin");
            Federacao.getInstance().setAdministrador(admin);
            System.out.println("Administrador registrado: " + admin.getNome());

            // Criar e adicionar barracas
            Barraca barraca1 = new Barraca("Barraca 1", "ISEP");
            Barraca barraca2 = new Barraca("Barraca 2", "FEUP");
            Federacao.getInstance().adicionarBarraca(barraca1);
            Federacao.getInstance().adicionarBarraca(barraca2);
            System.out.println("Barracas criadas: " + Federacao.getInstance().getBarracas().size());

            // Adicionar produtos
            Produto cerveja = new Produto("Cerveja", 2.0, 120);
            Produto sanduiche = new Produto("Sanduíche", 5.0, 30);
            if (barraca1.adicionarProduto(cerveja) && barraca2.adicionarProduto(sanduiche)) {
                System.out.println("Produtos adicionados às barracas.");
            } else {
                System.out.println("Erro ao adicionar produtos.");
            }

            // Adicionar voluntários
            Voluntario voluntarioVendas1 = new Voluntario("Joao", "12411", "Engenharia Civil", "ISEP", "Joao123", "VENDAS");
            Voluntario voluntarioVendas2 = new Voluntario("Ana", "12412", "Medicina", "FEUP", "Ana123", "VENDAS");
            Voluntario voluntarioStock = new Voluntario("Maria", "12413", "Gestão", "ISEP", "Maria123", "STOCK");

            if (barraca1.adicionarVoluntario(voluntarioVendas1) && barraca1.adicionarVoluntario(voluntarioStock) &&
                    barraca2.adicionarVoluntario(voluntarioVendas2)) {
                System.out.println("Voluntários adicionados:");
                System.out.println("- Barraca 1: João (VENDAS), Maria (STOCK)");
                System.out.println("- Barraca 2: Ana (VENDAS)");
            } else {
                System.out.println("Erro ao adicionar voluntários: instituição não correspondente.");
            }

            // Adicionar escalas de teste
            Escala escala1 = new Escala(LocalDate.of(2025, 5, 19));
            escala1.adicionarVoluntario(voluntarioVendas1);
            escala1.adicionarVoluntario(voluntarioStock);
            if (barraca1.adicionarEscala(escala1)) {
                System.out.println("Escala adicionada para Barraca 1 em 2025-05-19.");
            } else {
                System.out.println("Erro ao adicionar escala para Barraca 1.");
            }

            Escala escala2 = new Escala(LocalDate.of(2025, 5, 19));
            escala2.adicionarVoluntario(voluntarioVendas2);
            if (barraca2.adicionarEscala(escala2)) {
                System.out.println("Escala adicionada para Barraca 2 em 2025-05-19.");
            } else {
                System.out.println("Erro ao adicionar escala para Barraca 2.");
            }

            // Exibir estado inicial do sistema
            System.out.println("\n=== Estado Inicial do Sistema ===");
            System.out.println("Barracas:");
            Federacao.getInstance().getBarracas().forEach(b -> {
                System.out.println(b.toString());
                System.out.println("  Produtos: " + b.getProdutos());
                System.out.println("  Voluntários: " + b.getVoluntarios());
                System.out.println("  Escalas: " + b.getEscalas());
            });

            System.out.println("\nClassificações Iniciais:");
            System.out.println("Barracas:");
            Federacao.getInstance().getBarracas().forEach(b -> System.out.println(b.toString()));
            System.out.println("Voluntários de Vendas:");
            Federacao.getInstance().getBarracas().forEach(b ->
                    b.getVoluntarios().stream()
                            .filter(v -> v.getTipo().equals("VENDAS"))
                            .forEach(v -> System.out.println(v.toString())));

            // Iniciar o menu principal
            MenuInicial_UI menu = new MenuInicial_UI();
            menu.mostrar();

        } catch (Exception e) {
            System.err.println("Erro durante a inicialização do sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }
}