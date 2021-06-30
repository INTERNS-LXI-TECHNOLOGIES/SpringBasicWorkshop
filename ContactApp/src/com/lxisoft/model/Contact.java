package com.lxisoft.model;
import java.io.*;  
import java.util.*;  

public class Contact
{
private String name,number,eMail;
private int id;

public void setId(int id)
{
    this.id = id;
}

public void setName(String cname)                               
{ 
    this.name = cname; 
} 
                      
public void setNumber(String cnumber)
{
    this.number=cnumber;
}

public void setEmail(String mail)                       
{                          
    this.eMail=mail;
}

public int getId()
{
    return id;
}

public String getName(){ 
    return name; 
}    

public String getNumber(){
    return number;
}   

public String getEmail()
{
    return eMail;    }   

}