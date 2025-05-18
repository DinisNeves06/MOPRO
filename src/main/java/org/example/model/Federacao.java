package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Federacao implements Serializable {
    private static Federacao instance;
    private List<Barraca> barracas;
    private Administrador administrador;

    private Federacao() {
        this.barracas = new ArrayList<>();
        this.administrador = null;
    }

    public static Federacao getInstance() {
        if (instance == null) instance = new Federacao();
        return instance;
    }

    public List<Barraca> getBarracas() { return barracas; }
    public Administrador getAdministrador() { return administrador; }
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void adicionarBarraca(Barraca barraca) {
        barracas.add(barraca);
    }


    public void salvarDados(String arquivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Dados salvos com sucesso em " + arquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public static Federacao carregarDados(String arquivo) {
        try {
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Federacao federacao = (Federacao) in.readObject();
            in.close();
            fileIn.close();
            instance = federacao; // Atualiza a instância do Singleton
            System.out.println("Dados carregados com sucesso de " + arquivo);
            return federacao;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
            return null;
        }
    }
}