package com.lxisoft.dao;

import com.lxisoft.model.Contact;

import java.util.List;

public interface ContactDAO {
    public void saveContact(Contact contact);
    public List<Contact> getAllContacts(int start,int contactPerPage);
   // public int getNumberOfContacts();
    public  void deleteContact(int sno);
    public void getContactById(int sno);
    public void editContact(int sno);
    public void searchContactByName(String name);
    public int getNumberOfSearchedContacts();
}
