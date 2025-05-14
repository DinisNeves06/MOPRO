package model;

import org.example.model.Classificacao;

public class ClassificacaoImpl implements Classificacao {

    @Override
    public String classificar(double vendas, int stock) {
        if (vendas > 1000.0 && stock > 100) {
            return "Ouro";
        } else if (vendas >= 500.0 && vendas <= 1000.0 && stock >= 50 && stock <= 100) {
            return "Prata";
        } else {
            return "Bronze";
        }
    }

    // Método para classificar barracas
    public String classificarBarraca(Barraca barraca) {
        return classificar(barraca.getTotalVendas(), barraca.getTotalStock());
    }

    // Método para classificar voluntários com base nas vendas
    public String classificarVoluntario(VoluntarioVendas voluntario) {
        return classificar(voluntario.getTotalVendas(), 0); // Para voluntário, classificamos só pelas vendas
    }
}
