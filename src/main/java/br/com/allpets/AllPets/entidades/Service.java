package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
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
    private User fkOwner;

    @Column( length = 45)
    private LocalDate startTime;

    @Column( length = 45)
    private LocalDate stopTime;

    @Column( length = 45)
    private Double value;

    @JsonCreator
    public Service (@JsonProperty("idService") Integer idService ) {
        this.idService = idService;
    }

    @JsonProperty("idUser")
    private void fkOwner(Integer idUser) {
        this.fkOwner = new User(idUser);
        fkOwner.setIdUser(idUser);
    }

    @JsonProperty("idUser")
    private void fkCare(Integer idUser) {
        this.fkCare = new User(idUser);
        fkCare.setIdUser(idUser);
    }

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
        return fkOwner;
    }

    public void setFkOwnerS(User fkOwner) {
        this.fkOwner = fkOwner;
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

}
