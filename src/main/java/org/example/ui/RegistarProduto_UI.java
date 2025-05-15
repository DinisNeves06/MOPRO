package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Produto;
import org.example.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

class RegistarProduto_UI {
    private Scanner scanner;

    public RegistarProduto_UI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        System.out.print("Nome da barraca: ");
        String nomeBarraca = scanner.nextLine();
        Barraca barraca = Federacao.getInstance().getBarracas().stream()
                .filter(b -> b.getNome().equals(nomeBarraca))
                .findFirst()
                .orElse(null);

        if (barraca == null) {
            System.out.println("Barraca não encontrada!");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco;
        try {
            preco = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Preço inválido! Insira um número.");
            scanner.nextLine();
            return;
        }
        System.out.print("Stock inicial: ");
        int stock;
        try {
            stock = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Stock inválido! Insira um número.");
            scanner.nextLine();
            return;
        }

        if (preco <= 0 || stock < 0) {
            System.out.println("Preço ou stock inválido!");
            return;
        }

        Produto produto = new Produto(nome, preco, stock);
        barraca.adicionarProduto(produto);
        System.out.println("Produto '" + nome + "' adicionado com sucesso à barraca '" + nomeBarraca + "'!");
    }
}