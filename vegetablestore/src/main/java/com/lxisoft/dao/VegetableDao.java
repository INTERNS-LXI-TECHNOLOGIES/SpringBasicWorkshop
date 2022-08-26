package main.java.com.lxisoft.dao;
import java.io.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import main.java.com.lxisoft.vegetable.Vegetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class VegetableDao {

	public VegetableDao() {
	}

	public List<Vegetable> readVegetable(){


		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();


       String HQL = "from Vegetable";

		Query query = session.createQuery(HQL);

		List<Vegetable>vegetables = query.list();

		session.close();

		return vegetables;

	}


	public void addVegetable(Vegetable vegetable) throws IOException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
session.beginTransaction();

		InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

		byte[]image = new byte[inputStream.available()];

		inputStream.read(image);

		vegetable.setImage(image);

		session.save(vegetable);
		session.getTransaction().commit();

		session.close();

	}


	public List<Vegetable> selectData(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();


		List<Vegetable> vegetables = new ArrayList<>();

		Vegetable vegetable =session.get(Vegetable.class,id);

		session.getTransaction().commit();

		session.close();

		vegetables.add(vegetable);

		return vegetables;

	}
	public void updateVegetable(Vegetable vegetable) throws IOException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		 session.beginTransaction();

		InputStream inputStream =  new BufferedInputStream(vegetable.getImageFile().getInputStream());

		byte[]image = new byte[inputStream.available()];

		inputStream.read(image);
		vegetable.setImage(image);

		session.update(vegetable);

		session.getTransaction().commit();


		session.close();

	}

	public void deleteVegetable(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();
		Vegetable v = new Vegetable();
		v.setId(id);

		session.delete(v);
		session.getTransaction().commit();

		session.close();

	}


	public List<Vegetable> search(String word) {


		final String SEARCH_SQL = "select * from vegetablestore where name like'%"+word+"%';";

List<Vegetable> vegetables = new ArrayList<>();

try {

	 Statement st = connection.prepareStatement(SEARCH_SQL);

	ResultSet rs = st.executeQuery(SEARCH_SQL);


	while(rs.next()) {


		Blob blob = rs.getBlob(6);

		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		byte[] imageBytes = outputStream.toByteArray();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);



		inputStream.close();
		outputStream.close();

		vegetables.add(new Vegetable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), base64Image));

	}

}catch(Exception e) {
	e.printStackTrace();
}
		return vegetables;
	}
}