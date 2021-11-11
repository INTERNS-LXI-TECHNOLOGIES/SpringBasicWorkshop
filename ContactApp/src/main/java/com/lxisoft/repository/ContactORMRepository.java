package com.lxisoft.repository;

import com.lxisoft.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

public class ContactORMRepository implements ContactRepository {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveContact(Contact contact) {
       Session session = sessionFactory.getCurrentSession();
       session.save(contact);
    }

    @Override
    public List<Contact> getAllContacts(int start, int contactPerPage) {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Contact> contactCriteriaQuery = criteriaBuilder.createQuery(Contact.class);
        Root<Contact> root = contactCriteriaQuery.from(Contact.class);
        contactCriteriaQuery.orderBy(criteriaBuilder.asc(root.get("name")));
        Query query = session.createQuery(contactCriteriaQuery);
        query.setFirstResult(start);
        query.setMaxResults(contactPerPage);
        return query.getResultList();
    }

    @Override
    public int getNumberOfContacts() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        //Query query = session.createQuery("select count(*) from contacts");
        long total = (Long) session.createQuery("select count(*) from Contact contacts").getSingleResult();
        System.out.println("*****"+total+"*****");
        return (int) total;
    }

    @Override
    public void deleteContactById(int sno) {
        Session session = sessionFactory.getCurrentSession();
        Contact deleteContact = session.byId(Contact.class).load(sno);
        session.delete(deleteContact);
    }

    @Override
    public Contact getContactById(int sno) {
        Session session = sessionFactory.getCurrentSession();
        Contact contact = session.get(Contact.class,sno);
        return contact;
    }

    @Override
    public void editContact(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.update(contact);
    }

    @Override
    public List<Contact> searchContactByName(String name,int start,int contactPerPage) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from contacts where name like:searchKey");

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(sql.toString());
        query.setParameter("searchKey","%"+name+"%");
        query.setFirstResult(start);
        query.setMaxResults(contactPerPage);
        return query.getResultList();
        //Session session = sessionFactory.getCurrentSession();
        //Query query = session.createQuery("select * from Contact contacts where name like '%"+name+"'%'");
    }

    @Override
    public int getNumberOfSearchedContacts(String name) {
       /* int total = 0;
        String sql = "select count(*) from contacts where name like '%"+name+"%'";
        total = jdbcTemplate.queryForObject(sql,Integer.class);
        return total;*/
        return 0;
    }
}
