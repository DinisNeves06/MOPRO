package org.example.ui;
import org.example.model.Barraca;
import org.example.model.Federacao;

import java.util.List;

class MenuInstituicoes {
    public void mostrar() {
        System.out.println("\n=== Instituições Associadas ===");
        List<Barraca> barracas = Federacao.getInstance().getBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Nenhuma barraca registrada.");
        } else {
            barracas.forEach(b -> System.out.println(b.getNome() + ": " + b.getInstituicao()));
        }
    }
}