package org.example.ui;

import org.example.model.*;

public class QueimodromoManagementSystem {
    public static void main(String[] args) {
        // Criar administrador
        Administrador admin = new Administrador("Grok", "XAI001", "Inteligência Artificial", "xAI", "xai2025");
        Federacao.getInstance().setAdministrador(admin);

        // Criar barracas de exemplo
        Barraca barraca1 = new Barraca("Barraca Teste 1", "xAI");
        Barraca barraca2 = new Barraca("Barraca Teste 2", "xAI");
        Federacao.getInstance().adicionarBarraca(barraca1);
        Federacao.getInstance().adicionarBarraca(barraca2);

        // Adicionar produtos para testar classificações de barracas
        Produto cerveja = new Produto("Cerveja", 2.0, 120); // Stock alto -> Ouro
        Produto sanduiche = new Produto("Sanduíche", 5.0, 30); // Para barraca 2
        barraca1.adicionarProduto(cerveja);
        barraca2.adicionarProduto(sanduiche); // Stock baixo -> Bronze

        // Criar voluntários de exemplo
        try {
            Voluntario voluntarioVendas1 = new Voluntario("Joao", "V001", "Engenharia", "xAI", "senha123", "VENDAS");
            Voluntario voluntarioVendas2 = new Voluntario("Ana", "V003", "Medicina", "xAI", "senha789", "VENDAS");
            Voluntario voluntarioStock = new Voluntario("Maria", "V002", "Gestão", "xAI", "senha456", "STOCK");
            barraca1.adicionarVoluntario(voluntarioVendas1);
            barraca1.adicionarVoluntario(voluntarioStock);
            barraca2.adicionarVoluntario(voluntarioVendas2);
            System.out.println("Voluntários adicionados:");
            System.out.println("- Barraca Teste 1: João (VENDAS, senha: senha123), Maria (STOCK, senha: senha456)");
            System.out.println("- Barraca Teste 2: Ana (VENDAS, senha: senha789)");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar voluntários: " + e.getMessage());
        }

        // Simular vendas para testar classificações de voluntários
        barraca1.registrarVenda(600.0, barraca1.getVoluntarios().stream()
                .filter(v -> v.getNome().equals("Joao")).findFirst().orElse(null)); // Prata
        barraca2.registrarVenda(1200.0, barraca2.getVoluntarios().stream()
                .filter(v -> v.getNome().equals("Ana")).findFirst().orElse(null)); // Ouro

        // Exibir classificações iniciais
        System.out.println("\n=== Classificações Iniciais ===");
        System.out.println("Barracas:");
        Federacao.getInstance().getBarracas().forEach(b -> System.out.println(b.toString()));
        System.out.println("Voluntários de Vendas:");
        Federacao.getInstance().getBarracas().forEach(b ->
                b.getVoluntarios().stream()
                        .filter(v -> v.getTipo().equals("VENDAS"))
                        .forEach(v -> System.out.println(v.toString())));

        MenuInicial_UI menu = new MenuInicial_UI();
        menu.mostrar();
    }
}