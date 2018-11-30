package com.devlog.soaproject.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_person")
    private Integer idPerson;
    @Column(name = "name")
    private String name;
    @Column(name = "forename")
    private String forename;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL)
    private Set<Message> messages;

    public Person() {
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
