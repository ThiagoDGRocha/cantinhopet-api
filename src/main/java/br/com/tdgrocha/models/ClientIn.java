package br.com.tdgrocha.models;

public class ClientIn {

    private String nome;

    public ClientIn() {
    }

    public ClientIn(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
