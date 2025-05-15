package org.example.ui;

import org.example.model.Administrador;
import org.example.model.Federacao;
import org.example.model.Voluntario;

public class QueimodromoManagementSystem {
    public static void main(String[] args) {

        Administrador A1 = new Administrador("Dinis Neves","1241054","Engenharia Sistemas", "ISEP","massolas");
        Voluntario V1 = new Voluntario("Diogo França", "1241160", "Engenharia Sistemas","ISEP","pila","VENDAS");
        Voluntario V2 = new Voluntario("Gonçalo Silva", "1241095","Engenharia Sistemas","ISEP","cena","STOCK");
        Federacao.getInstance().setAdministrador(A1);
        Federacao.getInstance().setVoluntario(V1);
        Federacao.getInstance().setVoluntario(V2);
        MenuInicial_UI menu = new MenuInicial_UI();
        menu.mostrar();

    }
}
