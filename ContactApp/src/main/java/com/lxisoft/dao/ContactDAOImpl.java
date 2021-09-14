package com.lxisoft.dao;

import com.lxisoft.entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ContactDAOImpl implements ContactDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("from Contact").list();
    }

    @Override
    public void deleteContact(Integer contactID) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, contactID);
        if (contact != null){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }

    @Override
    public Contact updateContact(Contact contact) {
        sessionFactory.getCurrentSession().update(contact);
        return contact;
    }

    @Override
    public Contact getContactById(int contactId) {
        return (Contact) sessionFactory.getCurrentSession().get(
                Contact.class, contactId);
    }
}
