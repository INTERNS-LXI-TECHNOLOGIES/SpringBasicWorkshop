package com.lxisoft.repository;

import com.mysql.cj.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lxisoft.model.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressBookRepository {

	@Autowired
	private SessionFactory sessionFactory;
	private EntityManager session;

	public Contact getContactById(int id) {

	return sessionFactory.getCurrentSession().get(Contact.class,id);
	}
	public void saveContact(Contact contact)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

	@SuppressWarnings("unchecked")

	public List<Contact> viewData() {
		return sessionFactory.getCurrentSession().createQuery("From contact").list();

	}
	public void delete(int id)
	{
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(Contact.class, id);
		if(contact != null)
		{
			this.sessionFactory.getCurrentSession().delete(contact);
		}
	}
	public void add(Contact contact)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}
}


