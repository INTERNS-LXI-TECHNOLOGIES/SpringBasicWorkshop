package com.lxisoft.service;

import com.lxisoft.model.Contact;

import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    public void saveContact(Contact contact);
    public List<Contact> getAllContacts(int start,int contactPerPage);
    public int getNumberOfContacts() throws Exception;
    public  void deleteContactByName(int sno);
    public Contact getContactById(int sno) throws SQLException;
    public void editContact(Contact contact);
    public List<Contact> searchContactByName(String name,int start,int contactPerPage) throws SQLException;
    public int getNumberOfSearchedContacts(String name);
}
