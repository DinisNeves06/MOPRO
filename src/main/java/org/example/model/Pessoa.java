package org.example.model;

public abstract class Pessoa {
    protected String nome;
    protected String numeroAluno;
    protected String curso;
    protected String instituicao;
    protected String password;

    public Pessoa(String nome, String numeroAluno, String curso, String instituicao, String password) {
        this.nome = nome;
        this.numeroAluno = numeroAluno;
        this.curso = curso;
        this.instituicao = instituicao;
        this.password = password;
    }

    public String getNome() { return nome; }
    public String getNumeroAluno() { return numeroAluno; }
    public String getCurso() { return curso; }
    public String getInstituicao() { return instituicao; }
    public String getPassword() { return password; }

    public boolean autenticar(String nome, String password) {
        return this.nome.equals(nome) && this.password.equals(password);

    }
}

