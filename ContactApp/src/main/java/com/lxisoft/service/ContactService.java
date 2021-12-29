package com.lxisoft.service;

import com.lxisoft.model.Address;
import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressRepository;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContactService {//implements ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    AddressRepository addressRepository;

    @Transactional
    public List<Contact> getAllContacts(int start,int contactPerPage){
        Pageable pageable = PageRequest.of(start,contactPerPage,Sort.by("name"));
        Page<Contact> page = contactRepository.findAll(pageable);

        return page.getContent();
        //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
    }

   // @Override
    @Transactional
    public void saveContact(Contact contact) {
        /*List<Address> addresses = new ArrayList<>();
        addresses.add(address);
        //Contact contact = new Contact();
        contact.setAddress(addresses);*/
        contactRepository.save(contact);
    }

    @Transactional
    public int getNumberOfContacts(){
        int count = (int) contactRepository.count();
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
        contactRepository.deleteById(sno);
    }

   // @Override
    @Transactional
    public Contact getContactById(int sno) {
        Optional<Contact> contactToEdit = contactRepository.findById(sno);

        return contactToEdit.get();
    }

   // @Override
    @Transactional
    public void editContact(Contact contact) {
        contactRepository.save(contact);
    }

    @Transactional
    public List<Contact> searchContactByName(String name){
        return contactRepository.searchResult(name);
    }

    @Transactional
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
/*
    @Transactional
    public Address getAddressById(int id) {
        Optional<Address> addressById = addressRepository.findById(id);
        return  addressById.get();
    }
*/
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
