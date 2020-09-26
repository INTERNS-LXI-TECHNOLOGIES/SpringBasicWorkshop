package com.lxisoft.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lxisoft.model.Doctor;


public class Database 
{
	public void addDoctor(Doctor d) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Doctor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(d);
		tx.commit();
	}
	
	public ArrayList<Doctor> getDoctorRecords() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		Doctor d = new Doctor();
		Configuration con = new Configuration().configure().addAnnotatedClass(Doctor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		for(int i= 100;d!=null; i++)
		{
			d = (Doctor)session.get(Doctor.class,i);
			if(d!=null)
				doctors.add(d);
			
		}
		return doctors;
			
		
	}
	

	public void updateDatabase(Doctor d, int id) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Doctor.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		d.setDoctorId(id+100);
		session.update(d);
		tx.commit();
	}


}
