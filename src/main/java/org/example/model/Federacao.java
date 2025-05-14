package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Federacao {
    private static Federacao instance;
    private List<Barraca> barracas;
    private Administrador administrador;

    private Federacao() {
        this.barracas = new ArrayList<>();
        // Administrador único "Grok"
        this.administrador = new Administrador("Grok", "XAI001", "Inteligência Artificial", "xAI", "xai2025");
    }

    public static Federacao getInstance() {
        if (instance == null) {
            instance = new Federacao();
        }
        return instance;
    }

    public List<Barraca> getBarracas() { return barracas; }
    public Administrador getAdministrador() { return administrador; }

    public void adicionarBarraca(Barraca barraca) {
        barracas.add(barraca);
    }
}