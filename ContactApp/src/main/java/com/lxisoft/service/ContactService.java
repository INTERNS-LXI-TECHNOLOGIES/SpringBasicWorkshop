package com.lxisoft.service;

import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContactService {


    @Autowired
    private AddressBookRepository addressBookRepository;

    public Contact getContactById(int id)
    {

       return addressBookRepository.getContactById(id);

    }
    public void saveContact(Contact contact)
    {
        addressBookRepository.saveContact(contact);
    }

    @Transactional
    public List<Contact> viewData()
    {
       return addressBookRepository.viewData();

    }
    @Transactional

    public void delete(int id)
    {
        addressBookRepository.delete(id);
    }
    @Transactional

    public void add(Contact contact)
    {
        addressBookRepository.add(contact);
    }



}