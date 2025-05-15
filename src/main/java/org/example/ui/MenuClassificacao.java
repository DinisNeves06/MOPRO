package org.example.ui;
import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.util.List;

class MenuClassificacao {
    public void mostrar() {
        System.out.println("\n=== Classificação de Barracas ===");
        List<Barraca> barracas = Federacao.getInstance().getBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Nenhuma barraca registrada.");
        } else {
            barracas.forEach(b -> System.out.println(b.toString()));
        }

        System.out.println("\n=== Classificação de Voluntários ===");
        boolean temVoluntarios = false;
        for (Barraca b : barracas) {
            List<Voluntario> voluntariosVendas = b.getVoluntarios().stream()
                    .filter(v -> v.getTipo().equals("VENDAS") && v.getVendasDiarias() > 0)
                    .toList();
            if (!voluntariosVendas.isEmpty()) {
                temVoluntarios = true;
                voluntariosVendas.forEach(v -> System.out.println(v.toString()));
            }
        }
        if (!temVoluntarios) {
            System.out.println("Nenhum voluntário de vendas com vendas registradas.");
        }
    }
}