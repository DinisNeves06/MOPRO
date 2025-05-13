package org.example.model;

import org.example.utils.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EscalaDiaria {

    private Data data;
    private List<Barraca> barracas;
    private double vendasTotais;
    private int stockFinal;

    public EscalaDiaria(Data data){
        this.data = data;
        this.barracas = new ArrayList<>();
        this.vendasTotais = 0.0;
        this.stockFinal = 0;

    }

    public Data getData() {
        return data;
    }

    public List<Barraca> getBarracas() {
        return barracas;
    }

    public double getVendasTotais() {
        return vendasTotais;
    }

    public int getStockFinal() {
        return stockFinal;
    }
    public void adicionarVendaTotal(double vendas){
        this.vendasTotais += vendas;
    }
    public void adicionarStockFinal(int stock){
        this.stockFinal += stock;
    }
    public void adicionarBarraca(Barraca barraca){
        barracas.add(barraca);
    }
    public static EscalaDiaria criarEscalaHoje(){
        LocalDate hoje = LocalDate.now();
        Data dataHoje = new Data(hoje.getYear(), hoje.getDayOfMonth());
        return new EscalaDiaria(dataHoje);

    }

    @Override
    public String toString() {
        return "EscalaDiaria{" +
                "data=" + data +
                ", barracas=" + barracas +
                ", vendasTotais=" + vendasTotais +
                ", stockFinal=" + stockFinal +
                '}';
    }
}
