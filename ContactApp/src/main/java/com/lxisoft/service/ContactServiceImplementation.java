package com.lxisoft.service;


import com.lxisoft.model.Contact;
import com.lxisoft.repository.ContactJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ContactServiceImplementation {//implements ContactService {
    @Autowired
    ContactJPARepository contactJPARepository;

    @Transactional
    public List<Contact> getAllContacts(int pageNumber){
        return contactJPARepository.findAll(Sort.by("name"));
        //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
    }

   // @Override
    @Transactional
    public void saveContact(Contact contact) {
        contactJPARepository.save(contact);
    }

    @Transactional
    public int getNumberOfContacts(){
        int count = (int) contactJPARepository.count();
        return count;
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
    public Contact getContactById(int sno) {
        Optional<Contact> contactToEdit = contactJPARepository.findById(sno);

        return contactToEdit.get();
    }

   // @Override
    @Transactional
    public void editContact(Contact contact) {
        contactJPARepository.save(contact);
    }

    @Transactional
    public List<Contact> searchContactByName(String name){
        return contactJPARepository.searchResult(name);
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
