package br.com.allpets.AllPets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cuidador {
    @Id
    @GeneratedValue
    private Long idCuidador;

    @Column(length = 120)
    private String nome;

    @Column(length = 120)
    private String senha;

    @Column(length = 10)
    private Integer qtdAnimais;

    @Column(length = 10)
    private Double valorHora;

    @Column(length = 120)
    private String especialidade;

    @Column(length = 120)
    private String graduacao;

    public Long getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(Long idCuidador) {
        this.idCuidador = idCuidador;
    }

    public Integer getQtdAnimais() {
        return qtdAnimais;
    }

    public void setQtdAnimais(Integer qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
