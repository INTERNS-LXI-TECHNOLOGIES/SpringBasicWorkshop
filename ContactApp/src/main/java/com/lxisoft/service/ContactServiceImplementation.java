package com.lxisoft.service;


import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
@Service
public class ContactServiceImplementation implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts(int start,int contactPerPage) {
        return contactRepository.getAllContacts(start,contactPerPage);
    }

    @Override
    @Transactional
    public int getNumberOfContacts() throws Exception {
        return contactRepository.getNumberOfContacts();
    }

    @Override
    @Transactional
    public void deleteContactByName(int sno) {
        contactRepository.deleteContactById(sno);
    }

    @Override
    @Transactional
    public Contact getContactById(int sno) throws SQLException {
        return contactRepository.getContactById(sno);
    }

    @Override
    @Transactional
    public void editContact(Contact contact) {
        contactRepository.editContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> searchContactByName(String name, int start, int contactPerPage) throws SQLException {
        return contactRepository.searchContactByName(name, start, contactPerPage);
    }

    @Override
    @Transactional
    public int getNumberOfSearchedContacts(String name) {
        return contactRepository.getNumberOfSearchedContacts(name);
    }
}
