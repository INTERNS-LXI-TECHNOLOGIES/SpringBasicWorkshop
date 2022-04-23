package com.lxisoft.spring.dao;

import com.lxisoft.spring.model.Contact;
import java.util.List;

public interface ContactDAO {
    public int save(Contact contact);
    public Contact returnContact(Integer id);
    public int update(Contact contact);
    public int delete (Integer id);
    public List<Contact> listContacts();
}
