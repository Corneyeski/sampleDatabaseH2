package org.sample.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Enfermero {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Boolean active;

    public Enfermero() {
    }

    public Enfermero(Integer id, Boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
