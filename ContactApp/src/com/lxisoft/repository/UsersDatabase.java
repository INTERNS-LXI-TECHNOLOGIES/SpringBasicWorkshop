package com.lxisoft.repository;
import com.lxisoft.model.*;
import com.lxisoft.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class UsersDatabase{
	Connection con = null;
	PreparedStatement ps =null;
	//ResultStatement rs = null;
	Statement stmnt = null;
	int row;

	public void createDatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			try{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tomcat_users","root","abi@1003");	
			}catch(SQLException e)
			{	e.printStackTrace();	}
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public void addUsers(String name,String password){
		createDatabaseConnection();
		try{
			ps = con.prepareStatement("insert into users(username,password) values('"+name+"','"+password+"')");
			row = ps.executeUpdate();
			ps.close();
			con.close();
			this.addUserRoles(name);
		}
		catch(SQLException e)                                                                                    
		{
			e.printStackTrace();
		}
		//return row;                                                                   
	}
	public void addUserRoles(String name){
		createDatabaseConnection();
		String role = "user";
		try{
			ps = con.prepareStatement("insert into user_roles(username,role) values('"+name+"','"+role+"')");
			row = ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(SQLException e)                                                                                    
		{
			e.printStackTrace();
		}
		//return row;                                                                   
	}

	public boolean checkUser(String name,String password){
		boolean action = false;
		createDatabaseConnection();
		try{
			Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("select * from users where name='"+name+"'");
            if(rs.next()){
                if(rs.getString(3).equals(password)){
                    action = true;
                }
            }
            else{
                action = false;
                //out.println("Wrong password or username");
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		if(action == true){
			return true;
		}
		else{
			return false;
		}
	}
}