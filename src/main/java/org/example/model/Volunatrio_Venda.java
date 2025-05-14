package org.example.model;

public class Volunatrio_Venda extends Utilizador{
    public Volunatrio_Venda(String nome, int numAluno, String curso, String password) {
        super(nome, numAluno, curso, password);
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menu do Voluntário de Vendas:");
        System.out.println("1. Registar venda");
        System.out.println("2. Ver produtos à venda");
    }

}
