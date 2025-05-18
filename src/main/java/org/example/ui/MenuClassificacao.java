package org.example.ui;
import org.example.model.Barraca;
import org.example.model.Federacao;
import org.example.model.Voluntario;

import java.util.ArrayList;
import java.util.List;

class MenuClassificacao {
    public void mostrar() {
        System.out.println("=== Classificação de Barracas ===");
        List<Barraca> barracas = Federacao.getInstance().getBarracas();
        if (barracas.isEmpty()) {
            System.out.println("Nenhuma barraca registrada.");
        } else {
            for (int i = 0; i < barracas.size(); i++) {
                System.out.println(barracas.get(i).toString());
            }
        }
        System.out.println("=== Classificação de Voluntários ===");
        boolean temVoluntarios = false;
        List<Voluntario> voluntariosVendas = new ArrayList<>();

        // Iterar sobre barracas e voluntários usando loops
        for (int i = 0; i < barracas.size(); i++) {
            Barraca barraca = barracas.get(i);
            List<Voluntario> voluntarios = barraca.getVoluntarios();
            for (int j = 0; j < voluntarios.size(); j++) {
                Voluntario voluntario = voluntarios.get(j);
                if (voluntario.getTipo().equals("VENDAS") && voluntario.getVendasDiarias() > 0) {
                    voluntariosVendas.add(voluntario);
                    temVoluntarios = true;
                }
            }
        }

        if (!temVoluntarios) {
            System.out.println("Nenhum voluntário de vendas com vendas registradas.");
        } else {
            for (int i = 0; i < voluntariosVendas.size(); i++) {
                System.out.println(voluntariosVendas.get(i).toString());
            }
        }
    }
}