package com.lxisoft.model;

import javax.persistence.*;
import java.io.Serializable;

public class Address implements Serializable {
   // @Id
   // @Column(name = "")
   // String contactId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    @Column(name = "place_name")
    String houseName;
    @Column(name = "nationality")
    String nationality;


    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sno", nullable = false)
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

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

  /*  public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
    */

}
