package org.sample.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Enfermero enfermero;

    public Usuario() {
    }

    public Usuario(Integer id, String name, String lastname, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    public Usuario(Integer id, String name, String lastname, String password, Enfermero enfermero) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.enfermero = enfermero;
    }

    public Usuario(String name, String lastname, String password) {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }
}
