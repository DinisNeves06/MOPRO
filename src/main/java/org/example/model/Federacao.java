package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Federacao {
    private static Federacao instance;
    private List<Barraca> barracas;
    private Administrador administrador;

    private Federacao() {
        this.barracas = new ArrayList<>();
        this.administrador = null;
    }

    public static Federacao getInstance() {
        if (instance == null) instance = new Federacao();
        return instance;
    }

    public List<Barraca> getBarracas() { return barracas; }
    public Administrador getAdministrador() { return administrador; }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
        System.out.println("Administrador configurado: " + administrador.getNome());
    }

    public void adicionarBarraca(Barraca barraca) {
        barracas.add(barraca);
    }
}