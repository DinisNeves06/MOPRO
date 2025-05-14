package org.example.model;

public abstract class Voluntario {
    private String nome;
    private int numeroAluno;
    private Instituição instituicao;
    private Barraca barracaAssociada;

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int NUMERO_ALUNO_POR_OMISSAO = 0;
    private static final Instituição INSTITUIÇÃO_POR_OMISSAO = new Instituição("");

    public Voluntario (String nome, int numeroAluno, Instituição instituição){
        this.nome = nome;
        this.numeroAluno = numeroAluno;
        this.instituicao = instituição;
        this.barracaAssociada = null;
    }

    public Voluntario(){
        this.nome = NOME_POR_OMISSAO;
        this.numeroAluno = NUMERO_ALUNO_POR_OMISSAO;
        this.instituicao = INSTITUIÇÃO_POR_OMISSAO;
        this.barracaAssociada = null;
    }

    public Voluntario(Voluntario v){
        this.nome = v.nome;
        this.numeroAluno = v.numeroAluno;
        this.instituicao = v.instituicao;
        this.barracaAssociada = v.barracaAssociada;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroAluno() {
        return numeroAluno;
    }

    public void setNumeroAluno(int numeroAluno) {
        this.numeroAluno = numeroAluno;
    }

    public Instituição getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituição instituicao) {
        this.instituicao = instituicao;
    }

    public Barraca getBarracaAssociada() {
        return barracaAssociada;
    }

    public void setBarracaAssociada(Barraca barracaAssociada) {
        this.barracaAssociada = barracaAssociada;
    }

    @Override
    public String toString() {
        return "Voluntario{" +
                "nome='" + nome + '\'' +
                ", numeroAluno=" + numeroAluno +
                ", instituicao=" + instituicao +
                ", barracaAssociada=" + barracaAssociada +
                '}';
    }
}
