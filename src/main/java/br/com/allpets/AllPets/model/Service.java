package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Service {

    @Id
    @GeneratedValue
    private Integer idService;

    @ManyToOne
    private UserService fkUserService;

    @Column( length = 45)
    private Integer protocol;

    @Column( length = 45)
    private Date startTime;

    @Column( length = 45)
    private Date stopTime;

    @Column( length = 45)
    private Double value;

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public UserService getFkUserService() {
        return fkUserService;
    }

    public void setFkUserService(UserService fkUserService) {
        this.fkUserService = fkUserService;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
