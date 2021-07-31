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

    public int addToDatabase(Contact model)
    {
        createDatabaseConnection();
        try
        {
            ps = con.prepareStatement("insert into contacts(name,number,email) values('"+model.getName()+"','"+model.getNumber()+"','"+model.getEmail()+"')");
            row = ps.executeUpdate();
            ps.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return row;
    }

    public void deleteRecord(String delete)
    {
        createDatabaseConnection();
        try
        {
            String sql = "delete from contacts where name ='"+delete+"'";
            stmt = con.createStatement();
            stmt.executeUpdate(sql);

            stmt.close();
            con.close();
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }

    public void editList(Contact contact)
    {
        createDatabaseConnection();
        try
        {
            ps = con.prepareStatement("update contacts set name = '"+contact.getName()+"', number ='"+contact.getNumber()+"', email='"+contact.getEmail()+"' where sno='"+contact.getId()+"'");
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Contact> searchDatabase(String name) throws SQLException {
        createDatabaseConnection();
        List<Contact> searchList = new ArrayList<Contact>();
        Contact search = null;
        stmt = con .createStatement();
        rs = stmt.executeQuery("select * from contacts where name like '%"+name+"%' order by name");
        if(rs != null){
            while(rs.next()){
                search = new Contact();
                search.setName(rs.getString("name"));
                search.setNumber(rs.getString("number"));
                search.setEmail(rs.getString("email"));
                searchList.add(search);
            }
        }
        return searchList;
    }

}
