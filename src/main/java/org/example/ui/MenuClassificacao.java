package org.example.ui;
import org.example.model.Federacao;

class MenuClassificacao {
    public void mostrar() {
        System.out.println("\n=== Classificação de Barracas ===");
        Federacao.getInstance().getBarracas().forEach(b -> System.out.println(b.toString()));
        System.out.println("\n=== Classificação de Voluntários ===");
        Federacao.getInstance().getBarracas().forEach(b ->
                b.getVoluntarios().stream()
                        .filter(v -> v.getTipo().equals("VENDAS"))
                        .forEach(v -> System.out.println(v.toString())));
    }
}
