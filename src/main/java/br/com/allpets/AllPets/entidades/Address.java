package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer idAddress;

    @Column( length = 100)
    private Integer number;

    @Column( length = 45)
    private String bairro;

    @Column( length = 45)
    private String endereco;

    @Column( length = 45)
    private String city;

    @Column( length = 45)
    private String state;

    @Column(length = 25)
    private Integer cep;

    @Column( length = 25)
    private String complement;

    @ManyToOne
    private User fkUser;

    @JsonProperty("idUser")
    private void fk(Integer idUser) {
        this.fkUser = new User(idUser);
        fkUser.setIdUser(idUser);
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
