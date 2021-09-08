package com.lxisoft.dao;

import com.lxisoft.model.Contact;

import java.util.List;

public interface ContactDAO {
    public void addContact(Contact contact);

    public List<Contact> getAllContacts();

    public void deleteContact(Integer contactID);

    public Contact updateContact(Contact contact);

    public Contact getContactById(int contactId);
}
