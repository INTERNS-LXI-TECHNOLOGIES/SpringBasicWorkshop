package com.lxisoft.dao;

import com.lxisoft.model.Contact;

import java.util.List;

public interface ContactDAO {
    public void saveContact(Contact contact);
    public List<Contact> getAllContacts(int start,int contactPerPage);
    public int getNumberOfContacts();
    public  void deleteContactByName(String name);
    public List<Contact> getContactById(int sno);
    public void editContact(Contact contact);
    public List<Contact> searchContactByName(String name);
    public int getNumberOfSearchedContacts();
}
