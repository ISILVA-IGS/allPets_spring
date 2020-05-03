package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer idAddress;

    @Column( length = 100)
    private String street;

    @Column( length = 45)
    private String city;

    @Column( length = 45)
    private String state;

    @Column(length = 25)
    private Integer cep;

    @Column( length = 45)
    private String country;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
