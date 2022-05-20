package com.lxisoft.spring.service;

import com.lxisoft.spring.dao.ContactDAO;
import com.lxisoft.spring.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactDAO contactDao;

    @Override
    @Transactional
    public List<Contact> listAllContacts() {
        return contactDao.listAllContacts();
    }

    @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactDao.saveContact(contact);
    }

    @Override
    @Transactional
    public void deleteContact(int contact_id) {
        contactDao.deleteContact(contact_id);
    }

    @Override
    @Transactional
    public Contact getContact(int contact_id) {
        return contactDao.getContact(contact_id);
    }
}
