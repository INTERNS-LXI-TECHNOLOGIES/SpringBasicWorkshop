package com.lxisoft.repository;

import com.lxisoft.model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressBookRepository {


	@Autowired
	private SessionFactory sessionFactory;

	//private ContactService contactService;



	public Contact getContactById(int id) {

		return sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	public void saveContact(Contact contact) {
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> viewData() {

		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}


	public void delete(int id)
	{
		Session session ;
		Contact Contact;


		session = sessionFactory.getCurrentSession();
		Contact = (Contact)session.load(Contact.class,id);
		session.delete(Contact);

		session.flush() ;
	}
	public void add(Contact contact)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}
}


