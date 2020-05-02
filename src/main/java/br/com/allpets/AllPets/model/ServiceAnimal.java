package br.com.allpets.AllPets.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ServiceAnimal {
    
    @ManyToOne
    private Service fkService;

    @ManyToOne
    private Animal fkAnimal;

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
