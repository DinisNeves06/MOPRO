package org.example.ui;

import org.example.model.*;

public class QueimodromoManagementSystem {
    public static void main(String[] args) {

        Administrador admin = new Administrador("Antonio", "123", "Medicina", "FMUP", "admin");
        Federacao.getInstance().setAdministrador(admin);


        Barraca barraca1 = new Barraca("Barraca 1", "ISEP");
        Barraca barraca2 = new Barraca("Barraca 2", "FEUP");
        Federacao.getInstance().adicionarBarraca(barraca1);
        Federacao.getInstance().adicionarBarraca(barraca2);


        Produto cerveja = new Produto("Cerveja", 2.0, 120);
        Produto sanduiche = new Produto("Sanduíche", 5.0, 30);
        barraca1.adicionarProduto(cerveja);
        barraca2.adicionarProduto(sanduiche);


        try {
            Voluntario voluntarioVendas1 = new Voluntario("Joao", "12411", "Engenharia Civil", "FEUP", "Joao123", "VENDAS");
            Voluntario voluntarioVendas2 = new Voluntario("Ana", "12412", "Medicina", "FMUP", "Ana123", "VENDAS");
            Voluntario voluntarioStock = new Voluntario("Maria", "12413", "Gestão", "FEP", "Maria123", "STOCK");
            barraca1.adicionarVoluntario(voluntarioVendas1);
            barraca1.adicionarVoluntario(voluntarioStock);
            barraca2.adicionarVoluntario(voluntarioVendas2);
            System.out.println("Voluntários adicionados:");
            System.out.println("- Barraca 1: João (VENDAS, senha: senha123), Maria (STOCK, senha: senha456)");
            System.out.println("- Barraca 2: Ana (VENDAS, senha: senha789)");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar voluntários: " + e.getMessage());
        }




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