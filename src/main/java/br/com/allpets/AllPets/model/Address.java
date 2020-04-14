package br.com.allpets.AllPets.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer idAddress;

    @ManyToOne
    private User fkUserAdd;

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

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public User getFkUserAdd() {
        return fkUserAdd;
    }

    public void setFkUserAdd(User idUserAdd) {
        this.fkUserAdd = fkUserAdd;
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
