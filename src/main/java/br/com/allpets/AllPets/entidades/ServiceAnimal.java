package br.com.allpets.AllPets.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ServiceAnimal {

    @Id
    @GeneratedValue
    private Integer idServiceAnimal;

    @ManyToOne
    private Service fkService;

    @ManyToOne
    private Animal fkAnimal;

    @JsonProperty("idPet")
    private void fkPet(Integer idPet) {
        this.fkAnimal = new Animal(idPet);
        fkAnimal.setIdPet(idPet);
    }

    @JsonProperty("idService")
    private void fkService(Integer idService) {
        this.fkService = new Service(idService);
        fkService.setIdService(idService);
    }

    public Integer getIdServiceAnimal() {
        return idServiceAnimal;
    }

    public void setIdServiceAnimal(Integer idServiceAnimal) {
        this.idServiceAnimal = idServiceAnimal;
    }

    public Service getFkService() {
        return fkService;
    }

    public void setFkService(Service fkService) {
        this.fkService = fkService;
    }

    public Animal getFkAnimal() {
        return fkAnimal;
    }

    public void setFkAnimal(Animal fkAnimal) {
        this.fkAnimal = fkAnimal;
    }
}
