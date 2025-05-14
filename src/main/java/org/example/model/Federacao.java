package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Federacao {
    private String nome;
    private final List<Produto> lstProdutos;
    private final List<Instituição> instituições;
    private EscalaDiaria escalaAtual;
    private final List <Barraca> todasBarracas = new ArrayList<>();

    public Federacao(String nome) {
        this.nome = nome;
        this.lstProdutos = new ArrayList<>();
        this.instituições = new ArrayList<>();
    }

    public boolean adicionarProduto(Produto produto) {
        if (!listaContemProduto(produto.getNome())) {
            lstProdutos.add(new Produto(produto));
            return true;
        } else {
            return false;
        }
    }

    public boolean listaContemProduto(String nomeProduto) {
        for(Produto produto : lstProdutos){
            if(produto.getNome().equals(nomeProduto)){
                return true;
            }
        }
        return false;
    }

    public List<Produto> getLstProdutos(){
        return new ArrayList<>(lstProdutos);
    }

    public boolean adicionarInstituição(Instituição instituição){
        if (!instituiçãoExiste(instituição.getNome())){
            instituições.add(instituição);
            return true;
        }
        return false;
    }

    public List<Instituição> getInstituições(){
        return instituições;
    }

    public boolean listaContemInstituiçao (String nomeInstituiçao){
        for (Instituição inst : instituições){
            if (inst.getNome().equalsIgnoreCase(nomeInstituiçao)){
                return true;
            }
        }
        return false;

    }

    public boolean instituiçãoExiste (String nome){
        for (Instituição inst : instituições){
            if (inst.getNome().equalsIgnoreCase(nome)){
                return true;
            }
        }
        return false;

    }

    public VoluntarioVendas buscarVoluntarioVendasPorNumeroAluno(int numeroAluno){
        for (Instituição instituiçao : instituições){
            VoluntarioVendas voluntario = instituiçao.getVoluntarioVendasPorNumeroAluno(numeroAluno);
            if (voluntario != null){
                return voluntario;
            }

        }
        return null;
    }

    public List<Barraca> getTodasBarracas(){
        return todasBarracas;
    }

    public EscalaDiaria getEscalaAtual() {
        return escalaAtual;
    }

    public void setEscalaAtual(EscalaDiaria escalaAtual) {
        this.escalaAtual = escalaAtual;
    }

    public String getNome() {
        return nome;
    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Federacao: ");
        sb.append("nome='").append(nome).append("\n");
        sb.append("Lista de Produtos:");
        if (lstProdutos.isEmpty()) {
            sb.append(" (VAZIA)\n");
        } else {
            for (Produto produto : lstProdutos) {
                sb.append("\n\t- ").append(produto);
            }
        }
        // Completar
        return sb.toString();
    }

    public Administrador autenticarAdministrador(String nome, int numero, String curso, String instituicao, String password) {
        return null;
    }

    public Voluntario autenticarVoluntario(String nome, int numero, String curso, String instituicao, String password, Class<?> tipo) {
    }
}
    
    
