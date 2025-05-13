package org.example.model;

import java.util.*;

public class Federacao {
    private List<Barraca> barracas = new ArrayList<>();
    private List<Instituicao> instituicoes = new ArrayList<>();

    public Federacao() {
        // Criar dados de teste
        Instituicao isep = new Instituicao("ISEP");
        instituicoes.add(isep);

        Barraca barraca1 = new Barraca("Engenharia à Rasca", isep);

        Produto cerveja = new Produto("Cerveja", 100);
        Produto agua = new Produto("Água", 50);
        barraca1.adicionarProduto(cerveja);
        barraca1.adicionarProduto(agua);

        VoluntarioVenda joao = new VoluntarioVenda("João Silva", 12345, "Engenharia Informática", isep);
        VoluntarioVenda ana = new VoluntarioVenda("Ana Costa", 67890, "Engenharia Mecânica", isep);
        VoluntarioStock pedro = new VoluntarioStock("Pedro Lopes", 54321, "Engenharia Civil", isep);

        barraca1.adicionarVoluntario(joao);
        barraca1.adicionarVoluntario(ana);
        barraca1.adicionarVoluntario(pedro);

        barracas.add(barraca1);
    }

    public List<Barraca> getBarracas() {
        return barracas;
    }

    public List<Produto> getProdutos() {
        List<Produto> todos = new ArrayList<>();
        for (Barraca b : barracas) {
            todos.addAll(b.getProdutos());
        }
        return todos;
    }

    public Barraca getBarracaDoVoluntario(String nomeVoluntario) {
        for (Barraca b : barracas) {
            if (b.temVoluntario(nomeVoluntario)) return b;
        }
        return null;
    }

    public void mostrarDetalhesBarracas() {
        for (Barraca b : barracas) {
            System.out.println("\n--- Barraca: \"" + b.getNome() + "\" ---");
            System.out.println("Instituição: " + b.getInstituicao().getNome());
            System.out.println("Voluntários:");
            for (Voluntario v : b.getVoluntarios()) {
                System.out.println("- " + v.getNome() + " (" + v.getNumero() + ") - " + v.getCurso());
            }
            System.out.println("Stock:");
            for (Produto p : b.getProdutos()) {
                System.out.println("- " + p.getNome() + ": " + p.getQuantidade());
            }
        }
    }

    public void listarBarracasPorVendas() {
        barracas.sort((a, b) -> b.totalVendas() - a.totalVendas());
        for (Barraca b : barracas) {
            System.out.println(b.getNome() + " - Total Vendas: " + b.totalVendas());
        }
    }

    public void listarVoluntariosOrdenados() {
        List<Voluntario> todos = new ArrayList<>();
        for (Barraca b : barracas) {
            todos.addAll(b.getVoluntarios());
        }
        todos.sort(Comparator.comparingInt(Voluntario::getNumero));
        for (Voluntario v : todos) {
            System.out.println(v.getNumero() + " - " + v.getNome() + " (" + v.getCurso() + ")");
        }
    }

    public void listarVendasPorCategoria() {
        for (Barraca b : barracas) {
            System.out.println("Barraca: " + b.getNome());
            b.mostrarVendas();
        }
    }

    public void gravarDados() {
        System.out.println("Funcionalidade de gravação ainda não implementada.");
    }

    public void carregarDados() {
        System.out.println("Funcionalidade de carregamento ainda não implementada.");
    }
}
