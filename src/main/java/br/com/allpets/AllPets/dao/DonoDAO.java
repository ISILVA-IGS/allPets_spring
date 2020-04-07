package br.com.allpets.AllPets.dao;

import javax.persistence.*;

@Entity
public class DonoDAO {
    @Id
    @GeneratedValue
    private Long idDono;

    @Column(length = 120)
    private String nome;

    @Column(length = 10)
    private Integer idade;

    @Column(length = 120)
    private String senha;

    public Long getIdDono() {
        return idDono;
    }

    public void setIdDono(Long idDono) {
        this.idDono = idDono;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
