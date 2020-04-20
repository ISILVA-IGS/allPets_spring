package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer idUser;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column( length = 20)
    private Integer cpf;

    @Column( length = 20)
    private Integer rg;

    @Column( length = 10)
    private String birthDate;

    @Column ( length = 20)
    private String sex;

    @Column( length = 20)
    private Integer phone;
    @Column( length = 45)
    private Integer qtdAnimals;

    @Column( length = 45)
    private Double valueTime;

    @Column( length = 45)
    private String specialty;

    @Column( length = 45)
    private String graduation;

    @Column( length = 45)
    private String typePet;

    @OneToMany(mappedBy="fkUserAdd")
    private Set<Address> fkUserAdd = new HashSet<>();

    @OneToMany(mappedBy="fkOwner")
    private Set<TypeUser> fkOwner = new HashSet<>();

    public User() {}

    public Integer getIdUser() {
        return idUser;
    }

    public Set<TypeUser> getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(Set<TypeUser> fkOwner) {
        this.fkOwner = fkOwner;
    }

    public void setIdUser(Integer id) {
        this.idUser = idUser;
    }

    public Set<Address> getFkUserAdd() {
        return fkUserAdd;
    }

    public void setFkUserAdd(Set<Address> fkUserAdd) {
        this.fkUserAdd = fkUserAdd;
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

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public Integer getQtdAnimals() {
        return qtdAnimals;
    }

    public void setQtdAnimals(Integer qtdAnimals) {
        this.qtdAnimals = qtdAnimals;
    }

    public Double getValueTime() {
        return valueTime;
    }

    public void setValueTime(Double valueTime) {
        this.valueTime = valueTime;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
