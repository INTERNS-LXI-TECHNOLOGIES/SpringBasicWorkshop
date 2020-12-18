package com.lxisoft.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxisoft.repository.*;
import com.lxisoft.model.*;

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
    public List<Contact> viewData()
    {
       return addressBookRepository.viewData();

    }
    public void delete(int id)
    {
        addressBookRepository.delete(id);
    }
    public void add(Contact contact)
    {
        addressBookRepository.add(contact);
    }



}