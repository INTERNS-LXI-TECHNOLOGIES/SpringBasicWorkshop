package com.lxisoft.service;


import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactJPARepository;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service
public class ContactServiceImplementation {//implements ContactService {
    @Autowired
    ContactJPARepository contactJPARepository;

    @Transactional
    public List<Contact> getAllContacts(){
        return contactJPARepository.findAll(Sort.by("name"));
    }

   // @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactJPARepository.save(contact);
    }
/*
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
*/
 //   @Override
    @Transactional
    public void deleteContactById(int sno) {
        contactJPARepository.deleteById(sno);
    }

   // @Override
    @Transactional
    public Contact getContactById(int sno) throws SQLException {
        return contactJPARepository.getOne(sno);
    }

   // @Override
    @Transactional
    public void editContact(Contact contact) {
        contactJPARepository.save(contact);
    }

   /* @Override
    @Transactional
    public List<Contact> searchContactByName(String name, int start, int contactPerPage) throws SQLException {
        return contactRepository.searchContactByName(name, start, contactPerPage);
    }

    @Override
    @Transactional
    public int getNumberOfSearchedContacts(String name) {
        return contactRepository.getNumberOfSearchedContacts(name);
    }*/
}
