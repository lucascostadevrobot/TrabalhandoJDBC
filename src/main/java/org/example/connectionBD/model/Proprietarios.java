package org.example.connectionBD.model;

public class Proprietarios {
    private Integer id;
    private String nome;
    private Integer idade;
    private boolean ativo;

    public Proprietarios(Integer id, String nome, Integer idade, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
    }

    public Proprietarios(String nome, Integer idade, boolean ativo) {
        this.nome = nome;
        this.idade = idade;
        this.ativo = ativo;
    }


    public Proprietarios() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "proprietarios{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", ativo=" + ativo +
                '}';
    }
}
