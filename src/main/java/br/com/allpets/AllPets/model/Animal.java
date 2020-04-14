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

    @Column( length = 45)
    private String breed;

    @Column( length = 45)
    private Boolean medication;

    @Column( length = 10)
    private Double weight;

    @ManyToOne
    private TypeUser fkTypeUserA;

    @OneToMany(mappedBy="fkAnimal")
    private Set<TypeUser> fkAnimal = new HashSet<>();

    public Integer getIdPet() {
        return idPet;
    }

    public void setIdPet(Integer idPet) {
        this.idPet = idPet;
    }

    public Set<TypeUser> getFkAnimal() {
        return fkAnimal;
    }

    public void setFkAnimal(Set<TypeUser> fkAnimal) {
        this.fkAnimal = fkAnimal;
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

    public TypeUser getFkTypeUserA() {
        return fkTypeUserA;
    }

    public void setFkTypeUserA(TypeUser fkTypeUserA) {
        this.fkTypeUserA = fkTypeUserA;
    }
}
