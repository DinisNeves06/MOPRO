package org.example.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Escala implements Serializable {
    private LocalDate dia;
    private List<Voluntario> voluntarios;

    public Escala(LocalDate dia) {
        this.dia = dia;
        this.voluntarios = new ArrayList<>();
    }

    public LocalDate getDia() { return dia; }
    public List<Voluntario> getVoluntarios() { return voluntarios; }

    public boolean adicionarVoluntario(Voluntario voluntario) {
        if (voluntarios.size() < 2) {
            voluntarios.add(voluntario);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Escala: ").append(dia).append("\nVoluntários:\n");
        voluntarios.forEach(v -> sb.append("- ").append(v.getNome()).append(" (").append(v.getTipo()).append(")\n"));
        return sb.toString();
    }
}