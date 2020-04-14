package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Care {

    @Id
    @GeneratedValue
    private Integer idCare;

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

    @ManyToOne
    private TypeUser fkTypeUserC;

    @OneToMany(mappedBy="fkCare")
    private Set<TypeUser> fkCare = new HashSet<>();

    public TypeUser getFkTypeUserC() {
        return fkTypeUserC;
    }

    public void setFkTypeUserC(TypeUser fkTypeUserC) {
        this.fkTypeUserC = fkTypeUserC;
    }

    public Set<TypeUser> getFkCare() {
        return fkCare;
    }

    public void setFkCare(Set<TypeUser> fkCare) {
        this.fkCare = fkCare;
    }

    public Integer getIdCare() {
        return idCare;
    }

    public void setIdCare(Integer idCare) {
        this.idCare = idCare;
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
}
