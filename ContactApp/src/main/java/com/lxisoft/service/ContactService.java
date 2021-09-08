package com.lxisoft.service;

import com.lxisoft.model.Contact;

import java.util.List;

public interface ContactService {
    public void addContact(Contact contact);

    public List<Contact> getAllContacts();

    public void deleteContact(Integer contactId);

    public Contact getContact(int contactId);

    public Contact updateContact(Contact contact);
}
