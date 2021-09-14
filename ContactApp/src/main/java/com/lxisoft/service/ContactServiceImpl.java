package com.lxisoft.service;

import com.lxisoft.dao.ContactDAO;
import com.lxisoft.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactDAO contactDAO;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        contactDAO.addContact(contact);
    }

    @Override
    @Transactional
    public List<Contact> getAllContacts() {
        return contactDAO.getAllContacts();
    }

    @Override
    @Transactional
    public void deleteContact(Integer contactId) {
        contactDAO.deleteContact(contactId);
    }

    @Override
    @Transactional
    public Contact getContact(int contactId) {
        return contactDAO.getContactById(contactId);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactDAO.updateContact(contact);
    }

    public void setContactDAO(ContactDAO contactDAO){
        this.contactDAO = contactDAO;
    }
}
