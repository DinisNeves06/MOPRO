package org.example.model;

import java.util.Objects;

public class Utilizador {
    protected String nome;
    protected int numAluno;
    protected String curso;
    protected String password;

    public Utilizador(String nome,int numAluno, String curso, String password){
        this.nome=nome;
        this.numAluno=numAluno;
        this.curso=curso;
        this.password=password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }
    public int getNumAluno() {
        return numAluno;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getCurso() {
        return curso;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilizador{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", numAluno=").append(numAluno);
        sb.append(", curso='").append(curso).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizador that = (Utilizador) o;
        return numAluno == that.numAluno && Objects.equals(nome, that.nome) && Objects.equals(curso, that.curso) && Objects.equals(password, that.password);
    }
    public void mostrarMenu() {

    }
}
