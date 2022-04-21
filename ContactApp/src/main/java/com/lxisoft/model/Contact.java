package main.java.com.lxisoft.model;

public class Contact {
     private String firstName,lastName,phNumber,email;
	private int id;

public Contact(){

}

public Contact(int id,String n1,String n2,String ph,String mail){

this.id = id;
this.firstName = n1;
this.lastName = n2;
this.phNumber = ph;
this.email = mail;
	
}

public Contact(String n1,String n2,String ph,String mail){

	
	this.firstName = n1;
	this.lastName = n2;
	this.phNumber = ph;
	this.email = mail;
		
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName= firstName;
	}      
	public String getFirstName()
	{
		return this.firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName= lastName;
	}      
	public String getLastName()
	{
		return this.lastName;
	}
	public void setPhNumber(String number)
	{
		this.phNumber= number; 
	}
	public String getPhNumber()
	{
		return this.phNumber;
	}
     public void setEmail(String mail)
	{
		this.email= mail; 
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}

	public String toString() {
		return "id: "+this.id+"\nfirstName: "+firstName+"\nlastName: "+lastName
		+"\nphNumber: "+phNumber+"\nemail: "+email;
	}
}
