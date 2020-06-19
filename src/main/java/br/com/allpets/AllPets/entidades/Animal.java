package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private Integer idPet;

    @Column( length = 45)
    private String name;

    @Column( length = 10)
    private Integer age;

    @Column( length = 45)
    private String breed;

    @Column( length = 10)
    private String typePet;

    @Column( length = 45)
    private String size;

    @Column( length = 105)
    private String observacao;

    @OneToOne
    private User fkOwner;

    @JsonCreator
    public Animal (@JsonProperty("idPet") Integer idPet ) {
        this.idPet = idPet;
    }

    @JsonProperty("idUser")
    private void fkUser(Integer idUser) {
        this.fkOwner = new User(idUser);
        fkOwner.setIdUser(idUser);
    }

    public Animal(){}

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public User getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(User fkOwner) {
        this.fkOwner = fkOwner;
    }

    public String getTypePet() {
        return typePet;
    }

    public void setTypePet(String typePet) {
        this.typePet = typePet;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
