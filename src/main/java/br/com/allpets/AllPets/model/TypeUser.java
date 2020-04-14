package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TypeUser {

    @Id
    @GeneratedValue
    private Integer idTypeUser;

    @Column(length = 50)
    private String name;

    @ManyToOne
    private Care fkCare;

    @ManyToOne
    private Animal fkAnimal;

    @ManyToOne
    private User fkOwner;

    @OneToMany(mappedBy="fkTypeUserA")
    private Set<Animal> fkTypeUserA = new HashSet<>();

    @OneToMany(mappedBy="fkTypeUserC")
    private Set<Care> fkTypeUserC = new HashSet<>();

    @OneToMany(mappedBy="fkTypeUserU")
    private Set<UserService> fkTypeUserU = new HashSet<>();

    public Set<UserService> getFkTypeUserU() {
        return fkTypeUserU;
    }

    public void setFkTypeUserU(Set<UserService> fkTypeUserU) {
        this.fkTypeUserU = fkTypeUserU;
    }

    public Integer getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(Integer idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Care getFkCare() {
        return fkCare;
    }

    public void setFkCare(Care fkCare) {
        this.fkCare = fkCare;
    }

    public Animal getFkAnimal() {
        return fkAnimal;
    }

    public void setFkAnimal(Animal fkAnimal) {
        this.fkAnimal = fkAnimal;
    }

    public User getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(User fkDono) {
        this.fkOwner = fkOwner;
    }

    public Set<Animal> getFkTypeUserA() {
        return fkTypeUserA;
    }

    public void setFkTypeUserA(Set<Animal> fkTypeUserA) {
        this.fkTypeUserA = fkTypeUserA;
    }

    public Set<Care> getFkTypeUserC() {
        return fkTypeUserC;
    }

    public void setFkTypeUserC(Set<Care> fkTypeUserC) {
        this.fkTypeUserC = fkTypeUserC;
    }
}
