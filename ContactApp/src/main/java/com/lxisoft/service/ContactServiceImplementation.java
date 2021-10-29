package com.lxisoft.service;

import com.lxisoft.dao.ContactDAO;
import com.lxisoft.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ContactServiceImplementation implements ContactService {
    @Autowired
    ContactDAO contactDAO;

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactDAO.saveContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    @Transactional
    public int getNumberOfContacts() throws Exception {
        return contactDAO.getNumberOfContacts();
    }

    @Override
    @Transactional
    public void deleteContactByName(String name) {
        contactDAO.deleteContactByName(name);
    }

    @Override
    @Transactional
    public List<Contact> getContactById(int sno) {
        return contactDAO.getContactById(sno);
    }

    @Override
    @Transactional
    public void editContact(Contact contact) {
        contactDAO.editContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> searchContactByName(String name, int start, int contactPerPage) {
        return contactDAO.searchContactByName(name, start, contactPerPage);
    }

    @Override
    @Transactional
    public int getNumberOfSearchedContacts(String name) {
        return contactDAO.getNumberOfSearchedContacts(name);
    }
}
