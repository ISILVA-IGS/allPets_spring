package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {



    @Id
    @GeneratedValue
    private Integer idUser;

    @Column(columnDefinition = "boolean default false")
    private Boolean twoFactor;

    public Integer getTwoFactorCode() {
        return twoFactorCode;
    }

    public void setTwoFactorCode(Integer twoFactorCode) {
        this.twoFactorCode = twoFactorCode;
    }

    private Integer twoFactorCode;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column( length = 20)
    private String cpf;

    @Column( length = 10)
    private LocalDate birthDate;

    @Column( length = 20)
    private String whatsapp;

    @Column( length = 20)
    private String rg;

    @Column( length = 45)
    private String graduacao;

    @Column( length = 45)
    private Double valueTime;

    @Column( length = 45)
    private Integer typeUser;

    @ManyToOne
    private Address address;

    @JsonProperty("idAddress")
    private void fk(Integer idAddress) {
        this.address = new Address(idAddress);
        address.setIdAddress(idAddress);
    }

    @JsonCreator
    public User (@JsonProperty("idUser") Integer idUser ) {
        this.idUser = idUser;
    }

    public User(){}

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Double getValueTime() {
        return valueTime;
    }

    public void setValueTime(Double valueTime) {
        this.valueTime = valueTime;
    }


    public Boolean getTwoFactor() { return twoFactor; }

    public void setTwoFactor(Boolean twoFactor) { this.twoFactor = twoFactor; }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
