package main.java.com.lxisoft.dao;
import java.sql.*;
import main.java.com.lxisoft.vegetable.Vegetable;

public class VegetableDao {

	
private static final	String INSERT_SQL = "insert into vegetablestore" +
			"(name,price,stock,minOrderQuantity,image) values" +
					"(?,?,?,?,?);";
			
					private static final	String EDIT_SQL ="update vegetablestore set name = ?,price = ?,stock = ?,minOrderQuantity = ? where id =?;";
			
			
					private static final	String DELETE_SQL = "delete from vegetablestore where id = ?;";
	
	Connection connection;

	public VegetableDao()  {


try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft","root","Mubashir24092000");
} catch (Exception e) {
	e.printStackTrace();
}

	}
	
 
public int addVegetable(Vegetable vegetable) throws ClassNotFoundException  {
	
	int result = 0;
	
	try {
	
	PreparedStatement ps = 	connection.prepareStatement(INSERT_SQL);
		
		ps.setString(1,vegetable.getName());
		ps.setString(2,vegetable.getPrice());
		ps.setString(3,vegetable.getStock());
		ps.setString(4,vegetable.getOrderQuantity());
		ps.setBlob(5,vegetable.getImage());
		
		System.out.println(ps);
		
		result = ps.executeUpdate();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	return result;
	
	
}

public boolean updateVegetable(Vegetable vegetable) throws SQLException, ClassNotFoundException  {

	boolean rowUpdated;
		
		PreparedStatement statement = 	connection.prepareStatement(EDIT_SQL);

		statement.setInt(5,vegetable.getId());
		statement.setString(1,vegetable.getName());
		statement.setString(2,vegetable.getPrice());
		statement.setString(3,vegetable.getStock());
		statement.setString(4,vegetable.getOrderQuantity());

		
		System.out.println(statement);
		
		rowUpdated = statement.executeUpdate() >0;
		
	
	return rowUpdated;
	
}

public boolean deleteVegetable(int id) throws SQLException, ClassNotFoundException  {
	boolean rowDeleted;
	
	PreparedStatement statement = 	connection.prepareStatement(DELETE_SQL); 
		
		statement.setInt(1,id);
		
		System.out.println(statement);
		int result= statement.executeUpdate();
		
 rowDeleted = result >0;
		
	return rowDeleted;

}
}