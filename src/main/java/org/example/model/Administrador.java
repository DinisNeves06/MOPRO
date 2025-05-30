package org.example.model;

import java.io.Serializable;

public class Administrador extends Pessoa implements Serializable {
    public Administrador(String nome, String numeroAluno, String curso, String instituicao, String password) {
        super(nome, numeroAluno, curso, instituicao, password);
    }

    @Override
    public String toString() {
        return "Administrador: " + nome + " (" + numeroAluno + ", " + curso + ", " + instituicao+ ", " + password+ ")";
}
}