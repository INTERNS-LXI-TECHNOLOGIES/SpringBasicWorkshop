package com.lxisoft.spring.service;

import com.lxisoft.spring.entity.Contact;
import com.lxisoft.spring.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactRepository contactRepo;

    @Override

    public List<Contact> listAllContacts() {
        return contactRepo.findAll();
    }

    @Override

    public void saveContact(Contact contact) {
        contactRepo.save(contact);
    }

    @Override

    public void deleteContact(int contact_id) {
        contactRepo.deleteById(contact_id);
    }

    @Override

    public Contact getContact(int contact_id) {

        return contactRepo.findById(contact_id).get();
    }
}
