package org.example.model;

public class Voluntario extends Pessoa implements Classificavel {
    private String tipo; // "VENDAS" ou "STOCK"
    private double vendasDiarias;

    public Voluntario(String nome, String numeroAluno, String curso, String instituicao, String password, String tipo) {
        super(nome, numeroAluno, curso, instituicao, password);
        if (!tipo.equals("VENDAS") && !tipo.equals("STOCK")) {
            throw new IllegalArgumentException("Tipo de voluntário deve ser VENDAS ou STOCK");
        }
        this.tipo = tipo;
        this.vendasDiarias = 0.0;
    }

    public String getTipo() { return tipo; }
    public void setVendasDiarias(double vendas) { this.vendasDiarias = vendas; }
    public double getVendasDiarias() { return vendasDiarias; }

    @Override
    public String calcularClassificacao() {
        if (tipo.equals("VENDAS")) {
            if (vendasDiarias > 1000) {
                return "Ouro";
            } else if (vendasDiarias >= 500) {
                return "Prata";
            } else {
                return "Bronze";
            }
        }
        return "N/A"; // Voluntários de stock não têm classificação de vendas
    }

    @Override
    public String toString() {
        return "Voluntário: " + nome + " (" + numeroAluno + ", " + curso + ", " + tipo + ", " + instituicao + ", Classificação: " + calcularClassificacao()+")";
    }
}