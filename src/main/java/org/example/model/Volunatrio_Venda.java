package org.example.model;
import java.util.ArrayList;
import java.util.List;

public class VoluntarioVendas extends Voluntario {
    private List<VendaProdutos> vendas;

    public VoluntarioVendas(String nome, int numeroAluno, Instituição inst) {
        super(nome, numeroAluno, inst);
        this.vendas = new ArrayList<>();
    }

    public void adicionarVenda(VendaProdutos venda) {
        vendas.add(venda);
    }

    public List<VendaProdutos> getTodasVendas() {
        return vendas;
    }
}

