package org.example.ui;

import org.example.model.*;

public class Main {
    public static void main(String[] args) {
        Federacao federacao = Federacao.carregarDados("queimodromo.dat");
        if (federacao == null) {
            Administrador A1 = new Administrador("Dinis Neves","1241054","Engenharia Sistemas", "ISEP","massolas");
            Federacao.getInstance().setAdministrador(A1);
            Barraca barraca1 = new Barraca("TOCA A BEBER", "ISEP");
            Barraca barraca2 = new Barraca("BEBE TU", "FEUP");
            Barraca barracaNova = new Barraca("BEBADOS DO PORTO", "FEP"); // Barraca sem produtos
            Produto cerveja = new Produto("Cerveja", 2.0, 120); // Stock alto -> Ouro
            Produto sanduiche = new Produto("Sanduíche", 5.0, 30); // Stock baixo -> Bronze
            barraca1.adicionarProduto(cerveja);
            barraca2.adicionarProduto(sanduiche);
            Federacao.getInstance().adicionarBarraca(barraca1);
            Federacao.getInstance().adicionarBarraca(barraca2);
            Federacao.getInstance().adicionarBarraca(barracaNova);
            Voluntario voluntario1 = new Voluntario("Gonçalo", "1241095", "Engenharia Sistemas", "ISEP", "LINDO", "VENDAS");
            Voluntario voluntario2 = new Voluntario("Diogo", "1241056", "Engenharia Sistemas", "ISEP", "sistemas","STOCK");
            barraca1.adicionarVoluntario(voluntario1);
            barraca1.adicionarVoluntario(voluntario2);
        }
        MenuInicial_UI menu = new MenuInicial_UI();
        menu.mostrar();
        Federacao.getInstance().salvarDados("queimodromo.dat");
    }
}
