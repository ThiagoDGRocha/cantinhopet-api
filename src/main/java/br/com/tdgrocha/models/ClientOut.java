package br.com.tdgrocha.models;

public class ClientOut {

    private Integer id;

    private String nome;

    public ClientOut() { }

    public ClientOut(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
