package org.example.model;

public abstract class Voluntario {
    protected final String nome;
    protected final int numeroAluno;
    protected final String curso;
    protected final Instituicao instituicao;

    public Voluntario(String nome, int numeroAluno, String curso, Instituicao instituicao) {
        this.nome = nome;
        this.numeroAluno = numeroAluno;
        this.curso = curso;
        this.instituicao = instituicao;
    }

    public String getNome() {
        return nome;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    @Override
    public String toString() {
        return nome + " (" + numeroAluno + ") - " + curso;
    }
}