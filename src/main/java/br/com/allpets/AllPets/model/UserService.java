package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserService {

    @Id
    @GeneratedValue
    private Integer idUserService;

    @ManyToOne
    private TypeUser fkTypeUserU;

    @ManyToOne
    private TypeService fkTypeService;

    @OneToMany(mappedBy="fkUserService")
    private Set<Service> fkUserService = new HashSet<>();

    public Set<Service> getFkUserService() {
        return fkUserService;
    }

    public void setFkUserService(Set<Service> fkUserService) {
        this.fkUserService = fkUserService;
    }

    public Integer getIdUserService() {
        return idUserService;
    }

    public void setIdUserService(Integer idUserService) {
        this.idUserService = idUserService;
    }

    public TypeUser getFkTypeUserU() {
        return fkTypeUserU;
    }

    public void setFkTypeUserU(TypeUser fkTypeUser) {
        this.fkTypeUserU = fkTypeUserU;
    }

    public TypeService getFkTypeService() {
        return fkTypeService;
    }

    public void setFkTypeService(TypeService fkTypeService) {
        this.fkTypeService = fkTypeService;
    }
}
