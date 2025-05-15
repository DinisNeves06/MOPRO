package org.example.ui;

import org.example.model.*;

public class QueimodromoManagementSystem {
    public static void main(String[] args) {

        Administrador A1 = new Administrador("Dinis Neves","1241054","Engenharia Sistemas", "ISEP","massolas");
        Federacao.getInstance().setAdministrador(A1);
        Barraca barraca1 = new Barraca("Barraca Teste 1", "xAI");
        Barraca barraca2 = new Barraca("Barraca Teste 2", "xAI");
        Barraca barracaNova = new Barraca("Barraca Nova", "xAI"); // Barraca sem produtos
        Produto cerveja = new Produto("Cerveja", 2.0, 120); // Stock alto -> Ouro
        Produto sanduiche = new Produto("Sanduíche", 5.0, 30); // Stock baixo -> Bronze
        barraca1.adicionarProduto(cerveja);
        barraca2.adicionarProduto(sanduiche);
        Federacao.getInstance().adicionarBarraca(barraca1);
        Federacao.getInstance().adicionarBarraca(barraca2);
        Federacao.getInstance().adicionarBarraca(barracaNova);
        Voluntario voluntario1 = new Voluntario("Gonçalo", "1241095", "Engenharia Sistemas", "xAI", "PILA", "VENDAS");
        Voluntario voluntario2 = new Voluntario("Diogo", "1241056", "Engenharia Sistemas", "xAI", "cona","STOCK");
        barraca1.adicionarVoluntario(voluntario1);
        barraca1.adicionarVoluntario(voluntario2);
        MenuInicial_UI menu = new MenuInicial_UI();
        menu.mostrar();

    }
}
