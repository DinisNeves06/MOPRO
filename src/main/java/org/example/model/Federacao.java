package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Federacao {
    private static Federacao instance;
    private List<Barraca> barracas;
    private Administrador administrador;
    private Voluntario voluntario;

    private Federacao() {
        this.barracas = new ArrayList<>();
        // Administrador será definido na main
        this.administrador = null;
        this.voluntario = null;
    }

    public static Federacao getInstance() {
        if (instance == null) {
            instance = new Federacao();
        }
        return instance;
    }

    public List<Barraca> getBarracas() { return barracas; }

    public Administrador getAdministrador() {
        return administrador; }
    public void setAdministrador(Administrador administrador) { this.administrador = administrador; }

    public Voluntario getVoluntario() {
        return voluntario;
    }
    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

    public void adicionarBarraca(Barraca barraca) {
        barracas.add(barraca);
    }
}