package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Federacao {
    private String nome;
    private final List<Produto> lstProdutos;
    private final List<Instituição> instituições;
    private EscalaDiaria escalaAtual;
    private final List<Barraca> todasBarracas = new ArrayList<>();

    public Federacao(String nome) {
        this.nome = nome;
        this.lstProdutos = new ArrayList<>();
        this.instituições = new ArrayList<>();
    }

    public boolean adicionarProduto(Produto produto) {
        if (!listaContemProduto(produto.getNome())) {
            lstProdutos.add(new Produto(produto));
            return true;
        } else {
            return false;
        }
    }

    public boolean listaContemProduto(String nomeProduto) {
        for (Produto produto : lstProdutos) {
            if (produto.getNome().equals(nomeProduto)) {
                return true;
            }
        }
        return false;
    }

    public List<Produto> getLstProdutos() {
        return new ArrayList<>(lstProdutos);
    }

    public boolean adicionarInstituição(Instituição instituição) {
        if (!instituiçãoExiste(instituição.getNome())) {
            instituições.add(instituição);
            return true;
        }
        return false;
    }

    public List<Instituição> getInstituições() {
        return instituições;
    }

    public boolean listaContemInstituiçao(String nomeInstituiçao) {
        for (Instituição inst : instituições) {
            if (inst.getNome().equalsIgnoreCase(nomeInstituiçao)) {
                return true;
            }
        }
        return false;

    }

    public boolean instituiçãoExiste(String nome) {
        for (Instituição inst : instituições) {
            if (inst.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;

    }

    public VoluntarioVendas buscarVoluntarioVendasPorNumeroAluno(int numeroAluno) {
        for (Instituição instituiçao : instituições) {
            VoluntarioVendas voluntario = instituiçao.getVoluntarioVendasPorNumeroAluno(numeroAluno);
            if (voluntario != null) {
                return voluntario;
            }

        }
        return null;
    }

    public List<Barraca> getTodasBarracas() {
        return todasBarracas;
    }

    public EscalaDiaria getEscalaAtual() {
        return escalaAtual;
    }

    public void setEscalaAtual(EscalaDiaria escalaAtual) {
        this.escalaAtual = escalaAtual;
    }

    public String getNome() {
        return nome;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("==== FEDERAÇÃO ====\n");

        sb.append("Nome: ").append(nome).append("\n");

        // Produtos
        sb.append("\n--- Lista de Produtos ---\n");
        if (lstProdutos.isEmpty()) {
            sb.append("(VAZIA)\n");
        } else {
            for (Produto produto : lstProdutos) {
                sb.append("- ").append(produto).append("\n");
            }
        }

        // Barracas
        sb.append("\n--- Lista de Barracas ---\n");
        if (Barraca.isEmpty()) {
            sb.append("(VAZIA)\n");
        } else {
            for (Barraca barraca : Barraca) {
                sb.append("- ").append(barraca).append("\n");
            }
        }

        // Voluntários
        sb.append("\n--- Lista de Voluntários ---\n");
        if (Voluntario.isEmpty()) {
            sb.append("(VAZIA)\n");
        } else {
            for (Voluntario voluntario : Voluntario) {
                sb.append("- ").append(voluntario).append("\n");
            }
        }

        // Instituições
        sb.append("\n--- Lista de Instituições ---\n");
        if (Instituição.isEmpty()) {
            sb.append("(VAZIA)\n");
        } else {
            for (Instituição instituicao : Instituição) {
                sb.append("- ").append(instituicao).append("\n");
            }
        }

        // Escalas
        sb.append("\n--- Escalas ---\n");
        if (EscalaDiaria.isEmpty()) {
            sb.append("(VAZIA)\n");
        } else {
            for (EscalaDiaria escala : EscalaDiaria) {
                sb.append("- ").append(escala).append("\n");
            }
        }

        return sb.toString();
    }
}