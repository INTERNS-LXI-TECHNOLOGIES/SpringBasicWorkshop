package com.lxisoft.repository;

import com.lxisoft.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDatabase {
    Contact model = new Contact();
    Connection con = null;
    ResultSet rs= null;
    Statement stmt = null;
    PreparedStatement ps = null;;
    int row;

    public void createDatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactapp","root","abi@1003");
            }catch(SQLException e)
            {	e.printStackTrace();	}
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public List<Contact> viewDatabase()
    {
        createDatabaseConnection();
        List<Contact> list = new ArrayList<Contact>();
        Contact contact = null;
        try
        {
            String sql  = "select * from contacts order by name";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            //rs.absolute(start);
            //int i = 0;
            while(rs.next())
            {
                contact = new Contact();
                contact.setId(rs.getInt("sno"));
                contact.setName(rs.getString("name"));
                contact.setNumber(rs.getString("number"));
                contact.setEmail(rs.getString("email"));
                list.add(contact);
                //i++;
            }
            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public int numOfContacts() {
        createDatabaseConnection();
        int total = 0;
        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery("select count(*) from contacts");
            rs.next();
            total = rs.getInt(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return total;
    }
}
