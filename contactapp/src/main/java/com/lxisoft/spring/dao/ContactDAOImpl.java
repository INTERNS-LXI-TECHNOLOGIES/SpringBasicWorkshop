package com.lxisoft.spring.dao;

import com.lxisoft.spring.entity.Contact;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Contact> listAllContacts() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
        Root<Contact> root = cq.from(Contact.class);
        cq.select(root);
        Query<Contact> query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void saveContact(Contact contact) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(contact);
    }

    @Override
    public void deleteContact(int contact_id) {
        Session session = sessionFactory.getCurrentSession();
        Contact contact = session.byId(Contact.class).load(contact_id);
        session.delete(contact);
    }

    @Override
    public Contact getContact(int contact_id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Contact contact = currentSession.get(Contact.class, contact_id);
        return contact;
    }
}
