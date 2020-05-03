package br.com.allpets.AllPets.entidades;

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
