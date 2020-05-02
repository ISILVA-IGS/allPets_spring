package br.com.allpets.AllPets.model;

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

    @Column( length = 10)
    private Integer rga;

    @Column( length = 45)
    private String breed;

    @Column( length = 45)
    private Boolean medication;

    @Column( length = 10)
    private Double weight;

    @Column( length = 45)
    private String size;

    @ManyToOne
    private User fkOwnerA;

    @OneToMany(mappedBy="fkAnimal")
    private Set<ServiceAnimal> fkAnimal = new HashSet<>();

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

    public Boolean getMedication() {
        return medication;
    }

    public void setMedication(Boolean medication) {
        this.medication = medication;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getRga() {
        return rga;
    }

    public void setRga(Integer rga) {
        this.rga = rga;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public User getFkOwner() {
        return fkOwnerA;
    }

    public void setFkOwner(User fkOwner) {
        this.fkOwnerA = fkOwner;
    }

    public Set<ServiceAnimal> getFkAnimal() {
        return fkAnimal;
    }

    public void setFkAnimal(Set<ServiceAnimal> fkAnimal) {
        this.fkAnimal = fkAnimal;
    }
}
