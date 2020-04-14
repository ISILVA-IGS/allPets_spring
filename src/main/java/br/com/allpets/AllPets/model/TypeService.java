package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TypeService {

    @Id
    @GeneratedValue
    private Integer idTypeService;

    @Column(length = 100)
    private String nameService;

    @OneToMany(mappedBy="fkTypeService")
    private Set<UserService> fkTypeService = new HashSet<>();

    public Set<UserService> getFkTypeService() {
        return fkTypeService;
    }

    public void setFkTypeService(Set<UserService> fkTypeService) {
        this.fkTypeService = fkTypeService;
    }

    public Integer getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(Integer idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }
}
