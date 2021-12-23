package com.lxisoft.service;

import com.lxisoft.model.Address;
import com.lxisoft.repository.AddressRepository;
import com.lxisoft.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AddressService {
    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public ContactRepository contactRepository;

    @Transactional
    public void saveAddress(Address address){
        
    }

}
