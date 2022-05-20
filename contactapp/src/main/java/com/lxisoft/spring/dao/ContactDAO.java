package com.lxisoft.spring.dao;

import com.lxisoft.spring.entity.Contact;
import java.util.List;


public interface ContactDAO {
    List<Contact> listAllContacts();

    void saveContact(Contact contact);

    void deleteContact(int contact_id);

    Contact getContact(int contact_id);
}
