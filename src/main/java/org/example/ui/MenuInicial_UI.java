/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.example.ui;

//import model.ViagensTop;
//import utils.Utils;

import org.example.model.*;
import org.example.utils.Utils;

import java.io.IOException;
import java.util.Scanner;

public class MenuInicial_UI {
    private Federacao federacao;
    private String opcao;


    public MenuInicial_UI(Federacao federacao) {
       this.federacao = federacao;
    }

    public void run() throws IOException {
        do {
            System.out.println("###### MENU INICIAL #####");
            System.out.println("1. Administrador");
            System.out.println("2. Voluntário de Stock");
            System.out.println("3. Voluntário de Vendas");

            System.out.println("0. Sair");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if (opcao.equals("1")) {
                MenuAdministrador ui = new MenuAdministrador(federacao);
                ui.run();
            } else if (opcao.equals("2")) {
                MenuVoluntarioStock ui = new MenuVoluntarioStock(federacao);
                ui.run();
            } else if (opcao.equals("3")) {
                MenuVoluntarioVendas ui = new MenuVoluntarioVendas(federacao);
                ui.run();
            }
        }
        while (!opcao.equals("0"));
    }

    private void loginAdministrador() {
        System.out.println("\n--- Login Administrador ---");
        String nome = pedir("Nome: ");
        int numero = Integer.parseInt(pedir("Número de aluno: "));
        String curso = pedir("Curso: ");
        String instituicao = pedir("Instituição: ");
        String password = pedir("Password: ");

    }

    private void loginVoluntario(Class<?> tipo) {
        System.out.println("\n--- Login Voluntário (" + tipo.getSimpleName() + ") ---");
        String nome = pedir("Nome: ");
        int numero = Integer.parseInt(pedir("Número de aluno: "));
        String curso = pedir("Curso: ");
        String instituicao = pedir("Instituição: ");
        String password = pedir("Password: ");

        Voluntario v = federacao.autenticarVoluntario(nome, numero, curso, instituicao, password, tipo);
        if (v != null) {
            System.out.println("Login efetuado com sucesso como " + tipo.getSimpleName() + ".");

            if (VoluntarioVendas.class.isAssignableFrom(tipo)) {
                new MenuVoluntarioVendas(federacao, (VoluntarioVendas) v).mostrar();
            } else if (VoluntarioStock.class.isAssignableFrom(tipo)) {
                new MenuVoluntarioStock(federacao, (VoluntarioStock) v).mostrar();
            } else {
                System.out.println("Tipo de voluntário não reconhecido.");
            }

        } else {
            System.out.println("Credenciais inválidas.");
        }
    }


    private String pedir(String mensagem) {
        System.out.print(mensagem);
        Scanner scanner;
        return scanner.nextLine();
    }
}
