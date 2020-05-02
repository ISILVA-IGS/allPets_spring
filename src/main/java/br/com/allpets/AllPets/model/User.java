package br.com.allpets.AllPets.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {



    @Id
    @GeneratedValue
    private Integer idUser;

    @Column(columnDefinition = "boolean default false")
    private Boolean twoFactor;

    public Integer getTwoFactorCode() {
        return twoFactorCode;
    }

    public void setTwoFactorCode(Integer twoFactorCode) {
        this.twoFactorCode = twoFactorCode;
    }

    private Integer twoFactorCode;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String password;

    @Column( length = 20)
    private Integer cpf;

    @Column( length = 10)
    private LocalDate birthDate;

    @Column ( length = 20)
    private String sex;

    @Column( length = 20)
    private Integer phone;

    @Column( length = 45)
    private Double balanceCredit;

    @Column( length = 45)
    private Double valueTime;

    @Column( length = 45)
    private Integer typeUser;

    @OneToMany(mappedBy="fkUserAdd")
    private Set<Address> fkUserAdd = new HashSet<>();

    @OneToMany(mappedBy="fkOwnerA")
    private Set<Animal> fkOwnerA = new HashSet<>();

    @OneToMany(mappedBy="fkOwnerS")
    private Set<Service> fkOwnerS = new HashSet<>();

    @OneToMany(mappedBy="fkCare")
    private Set<Service> fkCare = new HashSet<>();

    public User() {}

    public Integer getIdUser() {
        return idUser;
    }

    public Set<Service> getFkOwnerS() {
        return fkOwnerS;
    }

    public void setFkOwnerS(Set<Service> fkOwner) {
        this.fkOwnerS = fkOwner;
    }

    public void setIdUser(Integer id) {
        this.idUser = idUser;
    }

    public Set<Address> getFkUserAdd() {
        return fkUserAdd;
    }

    public void setFkUserAdd(Set<Address> fkUserAdd) {
        this.fkUserAdd = fkUserAdd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPhone() {
        return phone;
    }

    public Double getValueTime() {
        return valueTime;
    }

    public void setValueTime(Double valueTime) {
        this.valueTime = valueTime;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Boolean getTwoFactor() { return twoFactor; }

    public void setTwoFactor(Boolean twoFactor) { this.twoFactor = twoFactor; }

    public Double getBalanceCredit() {
        return balanceCredit;
    }

    public void setBalanceCredit(Double balanceCredit) {
        this.balanceCredit = balanceCredit;
    }

    public Integer getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(Integer typeUser) {
        this.typeUser = typeUser;
    }

    public Set<Service> getFkCare() {
        return fkCare;
    }

    public void setFkCare(Set<Service> fkCare) {
        this.fkCare = fkCare;
    }

    public Set<Animal> getFkOwnerA() {
        return fkOwnerA;
    }

    public void setFkOwnerA(Set<Animal> fkOwnerA) {
        this.fkOwnerA = fkOwnerA;
    }
}
