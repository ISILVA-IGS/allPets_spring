package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer idService;

    @ManyToOne
    private User fkCare;

    @ManyToOne
    private User fkOwnerS;

    @Column( length = 45)
    private LocalDate startTime;

    @Column( length = 45)
    private LocalDate stopTime;

    @Column( length = 45)
    private Double value;

    @OneToMany(mappedBy="fkAnimal")
    private Set<ServiceAnimal> fkAnimal = new HashSet<>();

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public User getFkCare() {
        return fkCare;
    }

    public void setFkCare(User fkCare) {
        this.fkCare = fkCare;
    }

    public User getFkOwnerS() {
        return fkOwnerS;
    }

    public void setFkOwnerS(User fkOwner) {
        this.fkOwnerS = fkOwner;
    }


    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDate stopTime) {
        this.stopTime = stopTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<ServiceAnimal> getFkAnimal() {
        return fkAnimal;
    }

    public void setFkAnimal(Set<ServiceAnimal> fkAnimal) {
        this.fkAnimal = fkAnimal;
    }
}
