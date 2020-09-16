package com.lxisoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {


    private static final long serialVersionUID = 875002956757661492L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String place;

    @Column
    private String number;

    @Column
    private String branch;

    @Column
    private String doctor;

    @Column
    private String dateandTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) { this.place = place; }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String session) {
        this.branch = session;
    }

    public String getDoctor() { return doctor; }

    public void setDoctor(String doctor) { this.doctor = doctor; }

    public String getDateandTime() { return dateandTime;   }

    public void setDateandTime(String dateandTime) { this.dateandTime = dateandTime;   }
}