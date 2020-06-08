package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer idService;

    @ManyToOne
    private User fkOwner;

    @ManyToOne
    private User fkCare;

    @Column( length = 45)
    private LocalDate startTime;

    @Column( length = 45)
    private LocalDate stopTime;

    @Column( length = 45)
    private Double value;

    @Column( length = 45)
    private Integer qtdTime;

    @Column( length = 250)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getQtdTime() {
        return qtdTime;
    }

    public void setQtdTime(Integer qtdTime) {
        this.qtdTime = qtdTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column( length = 45)
    private Integer status;



    @JsonCreator
    public Service (@JsonProperty("idService") Integer idService ) {
        this.idService = idService;
    }

    @JsonProperty("idUsers")
    private void fkUsers(Integer idUser) {
        this.fkCare = new User(idUser);
        fkCare.setIdUser(idUser);

    }

    @JsonProperty("idUser")
    private void fkUser(Integer idUser) {
        this.fkOwner = new User(idUser);
        fkOwner.setIdUser(idUser);

    }


    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }


    public Service(){};


    public User getFkOwner() {
        return fkOwner;
    }

    public void setFkOwner(User fkOwner) {
        this.fkOwner = fkOwner;
    }

    public User getFkCare() {
        return fkCare;
    }

    public void setFkCare(User fkCare) {
        this.fkCare = fkCare;
    }
}
