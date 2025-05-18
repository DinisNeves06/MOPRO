package org.example.ui;

import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Produto;
import org.example.utils.Utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class RegistarProduto_UI {
    private Scanner scanner;

    public RegistarProduto_UI() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrar() {
        System.out.print("Nome da barraca: ");
        String nomeBarraca = scanner.nextLine().trim();
        Barraca barraca = null;
        for (Barraca b : Federacao.getInstance().getBarracas()) {
            if (b.getNome().equals(nomeBarraca)) {
                barraca = b;
                break;
            }
        }

        if (barraca == null) {
            System.out.println("Erro: O sistema não conseguiu localizar a barraca '" + nomeBarraca + "'!");
            System.out.println("Barracas disponíveis:");
            for (Barraca b : Federacao.getInstance().getBarracas()) {
                System.out.println("- " + b.getNome() + " (Instituição: " + b.getInstituicao() + ")");
            }
            return;
        }

        // Listar produtos existentes da barraca
        System.out.println("=== Produtos da barraca '" + nomeBarraca + "' ===");
        List<Produto> produtos = barraca.getProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado nesta barraca.");
        } else {
            for (Produto p : produtos) {
                System.out.println("- " + p.getNome() + " (Preço: €" + p.getPreco() + ", Stock: " + p.getStock() + ")");
            }
        }

        // Adicionar novo produto
        System.out.print("Deseja adicionar um novo produto? (Sim/Não): ");
        String resposta = scanner.nextLine();
        if (!resposta.equals("Sim")) {
            System.out.println("Operação cancelada.");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine().trim();
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