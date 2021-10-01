package com.lxisoft.service;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository repository;

    public Contact getContactByID(int id){
        return repository.getOne(id);
    }

    public void saveContact(Contact contact){
        repository.save(contact);
    }

    public List<Contact> viewContact(){
        return repository.findAll();
    }

    public void deleteContactById(int id){
        repository.deleteById(id);
    }

    public void addContact(Contact contact){
        this.saveContact(contact);
    }
}
