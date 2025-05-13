package org.example.model;

public class Administrador extends Utilizador {

    public Administrador(String nome, int numeroAluno, String curso, String password) {
            super(nome, numeroAluno, curso, password);
        }

        @Override
        public void mostrarMenu() {
            System.out.println("===== Menu do Administrador =====");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Adicionar instituição");
            System.out.println("3. Criar barraca");
            System.out.println("4. Ver lista de barracas");
            System.out.println("4. Ver lista de produtos");
            System.out.println("5. Ver lista de instituições");
            System.out.println("7. Ver lista de voluntários");
            System.out.println("8. Consultar/Editar escalas");
            System.out.println("9. Classificação de barracas e voluntários de vendas");
            System.out.println("10. Sair");
            System.out.println("=================================");
    }
}
