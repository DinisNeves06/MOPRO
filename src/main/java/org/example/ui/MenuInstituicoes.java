package org.example.ui;
import org.example.model.Federacao;

class MenuInstituicoes {
    public void mostrar() {
        System.out.println("\n=== Instituições Associadas ===");
        Federacao.getInstance().getBarracas().forEach(b ->
                System.out.println(b.getNome() + ": " + b.getInstituicao()));
    }
}