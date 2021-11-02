package com.lxisoft.dao;

import com.lxisoft.model.Contact;

import java.util.List;

public interface ContactDAO {
    public void saveContact(Contact contact);
    public List<Contact> getAllContacts();
    public int getNumberOfContacts() throws Exception;
    public  void deleteContactByName(int sno);
    public List<Contact> getContactById(int sno);
    public void editContact(Contact contact);
    public List<Contact> searchContactByName(String name,int start,int contactPerPage);
    public int getNumberOfSearchedContacts(String name);
}
