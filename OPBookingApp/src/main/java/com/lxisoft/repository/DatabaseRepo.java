package com.lxisoft.repository;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lxisoft.model.Doctor;
import com.lxisoft.model.Patient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseRepo {

	private Connection con;
	private Statement s;
	private ResultSet r;

	public void createDatabaseConnection() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/BookingApp", "root", "root");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void addDoctor(Doctor d)
	{
		createDatabaseConnection();
		try
		{
			s=(Statement) con.createStatement();
			s.executeUpdate("insert into Doctor values('"+d.getName()+"','"+d.getDepartment()+"')");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Doctor> getDoctorRecords()
	{
		createDatabaseConnection();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		int i=0;
		try
		{
			s = (Statement) con.createStatement();
			r = s.executeQuery("select * from Doctor");
			while(r.next())
			{
				doctors.add(i,new Doctor());
				doctors.get(i).setName(r.getString("name"));
				doctors.get(i).setDepartment(r.getString("section"));
				i++;		
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();			
		}
		return doctors;
	}

	public void updateDatabase(ArrayList<Doctor> doctors)
	{
		createDatabaseConnection();
		try
			{
				s=(Statement) con.createStatement();
				s.executeUpdate("truncate table Doctor");	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		for(Doctor d : doctors)
		{
			try
			{
				s=(Statement) con.createStatement();
				s.executeUpdate("insert into Doctor values ('" + d.getName()+"','" + d.getDepartment() + "')");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void addPatient(Patient p)
	{
		createDatabaseConnection();
		try
		{
			s=(Statement) con.createStatement();
			s.executeUpdate("insert into Patient values('"+p.getName()+"','"+p.getDoctorName()+"')");	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
		
	

}
