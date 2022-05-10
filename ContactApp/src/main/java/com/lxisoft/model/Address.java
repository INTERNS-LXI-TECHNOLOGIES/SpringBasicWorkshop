package com.lxisoft.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    
    @Column(name = "place_name")
    String placeName;
    
    @Column(name = "nationality")
    String nationality;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "contact_id",nullable = false)*/
    public Contact contact;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
