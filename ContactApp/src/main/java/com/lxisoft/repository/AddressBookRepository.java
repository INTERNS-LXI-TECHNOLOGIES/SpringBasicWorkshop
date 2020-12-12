package com.lxisoft.repository;

import java.sql.*;
import java.util.ArrayList;

import com.lxisoft.model.Contact;

public class AddressBookRepository {
	ArrayList<Contact> contactList=new ArrayList<Contact>();



	Connection con = null;
	PreparedStatement ps = null;
	int row;

	//ArrayList<Contact> contactList=new ArrayList<Contact>();
	public void save(Contact contact) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "Karthik1996$");

			ps = con.prepareStatement("insert into contact(NAME,Number,Email) values(?,?,?)");
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getNumber());
			ps.setString(3, contact.getEmail());
		} catch (Exception e) {
		}



	}
	public void edit(String id,String name,String number,String email)
	{
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","Karthik1996$");
			Statement stm = con.createStatement();
			ps = con.prepareStatement("update contact set NAME=?,Number=?,Email=? where ID =?");
			ps.setString(1,name);
			ps.setString(2,number);
			ps.setString(3,email);
			ps.setString(4,id);


			ps.executeUpdate();
		}
		catch(Exception e)
		{

		}

	}
	public void deleteName(String name)
	{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","Karthik1996$");
			Statement stmt = con.createStatement();

			String query="delete from contact where name=?";
			ps=con.prepareStatement(query);
			ps.setString(1,name);
			ps.executeUpdate();



		}
		catch(Exception e){

		}
	}

	public ArrayList<Contact> read()
	{
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","Karthik1996$");

			contactList.clear();

			Statement stmt = con.createStatement();

			PreparedStatement ps=con.prepareStatement("select * from contact");
			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				Contact contact=new Contact();

				contact.setID(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setNumber(rs.getString("number"));
				contact.setEmail(rs.getString("email"));
				contactList.add(contact);
			}
			stmt.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return contactList;
	}
}
			
