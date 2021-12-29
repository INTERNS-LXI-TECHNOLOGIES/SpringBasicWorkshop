package com.lxisoft.service;

import com.lxisoft.model.Address;
import com.lxisoft.model.Contact;
import com.lxisoft.repository.AddressRepository;
import com.lxisoft.repository.ContactRepository;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class AddressService {
    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public ContactRepository contactRepository;

    @Transactional
    public void saveAddress(Address address){
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        Contact contact = new Contact();
        contact.setAddress(addresses);
        contactRepository.save(contact);
    }

}
