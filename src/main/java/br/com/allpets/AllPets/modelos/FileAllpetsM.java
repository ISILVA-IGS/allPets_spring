package br.com.allpets.AllPets.modelos;

import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.entidades.User;

import java.time.LocalDate;

public class FileAllpetsM {

    private Integer idService;

    private LocalDate startTime;

    private LocalDate stopTime;

    private Double value;

    public FileAllpetsM(Service service) {
        this.idService = service.getIdService();
        this.startTime = service.getStartTime();
        this.stopTime = service.getStopTime();
        this.value = service.getValue();
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

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }
}
