package br.com.tdgrocha.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
@SequenceGenerator(
        name = "clientSeq",
        sequenceName = "client_id_seq",
        allocationSize = 1,
        initialValue = 1
)
public class ClientEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clientSeq"
    )
    private Integer id;
    private String nome;

    public ClientEntity() {
    }

    public ClientEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
