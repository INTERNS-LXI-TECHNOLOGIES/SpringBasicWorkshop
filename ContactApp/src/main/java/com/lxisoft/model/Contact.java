package com.lxisoft.model;
import org.springframework.data.jpa.repository.EntityGraph;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.*;

@Entity
@Table(name="contact")

public class Contact implements Serializable
{
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String number;
	@Id
	private int ID;


public int getID() {

	return ID;
   }
   public void setID(int id) {

	ID = id;
   }
	public void setName(String name)
	{

		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
	public String getNumber()
	{
		return number;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getEmail()
	{
		return email;
	}
	public String toString()
	{
		return "\n"+"name :"+name+"    number :"+number+"  email :"+email+"\n";
	}
}