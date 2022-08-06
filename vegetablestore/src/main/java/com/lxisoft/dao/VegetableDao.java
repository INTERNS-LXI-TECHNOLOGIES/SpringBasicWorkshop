package main.java.com.lxisoft.dao;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import main.java.com.lxisoft.vegetable.Vegetable;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public class VegetableDao {

	
private static final	String INSERT_SQL = "insert into vegetablestore" +
			"(name,price,stock,minOrderQuantity,image) values" +
					"(?,?,?,?,?);";
			
					private static final	String EDIT_SQL ="update vegetablestore set name = ?,price = ?,stock = ?,minOrderQuantity = ? where id =?;";

					private static final String READ_SQL ="select * from vegetablestore;";

					private static final	String DELETE_SQL = "delete from vegetablestore where id = ?;";

	private static final String SELECT_SQL ="select * from vegetablestore where id=?; ";

	
	Connection connection;

	public VegetableDao()  {


try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/lxisoft","root","Mubashir24092000");

} catch (Exception e) {
	e.printStackTrace();
}

	}
	PreparedStatement ps;
	public List<Vegetable> readVegetable() {


		List<Vegetable> vegetables = new ArrayList<Vegetable>();
		try {

			Statement st = connection.createStatement();

			ResultSet rs = st.executeQuery(READ_SQL);

			while (rs.next()) {

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
		}catch(Exception e){
			e.printStackTrace();
		}
		return  vegetables;
		}


 
public int addVegetable(Vegetable vegetable) throws ClassNotFoundException  {
	
	int result = 0;
	
	try {
	
	 ps = 	connection.prepareStatement(INSERT_SQL);
		
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
		
		ps = 	connection.prepareStatement(EDIT_SQL);

		ps.setInt(5,vegetable.getId());
		ps.setString(1,vegetable.getName());
		ps.setString(2,vegetable.getPrice());
		ps.setString(3,vegetable.getStock());
		ps.setString(4,vegetable.getOrderQuantity());

		
		System.out.println(ps);
		
		rowUpdated = ps.executeUpdate() >0;
		
	
	return rowUpdated;
	
}

public boolean deleteVegetable(int id) throws SQLException, ClassNotFoundException  {
	boolean rowDeleted;
	
	ps= 	connection.prepareStatement(DELETE_SQL);
		
		ps.setInt(1,id);
		
		System.out.println(ps);
		int result= ps.executeUpdate();
		
 rowDeleted = result >0;
		
	return rowDeleted;

}

	public List<Vegetable> selectData(int id){

		List<Vegetable>vegetable = new ArrayList<>();
		try {
			 ps = connection.prepareStatement(SELECT_SQL);
			ps.setInt(1,id);

			System.out.println(ps);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				int vegId = rs.getInt(1);
				String name = rs.getString(2);
				String price = rs.getString(3);
				String stock = rs.getString(4);
				String orderQuantity = rs.getString(5);

				vegetable.add(new Vegetable(vegId, name, price, stock, orderQuantity));

			}
		}catch(Exception e){

			e.printStackTrace();
		}

		return vegetable;
	}

	public List<Vegetable> search(String word) {


		final String SEARCH_SQL = "select * from vegetablestore where name like'%"+word+"%';";

List<Vegetable> vegetables = new ArrayList<>();

try {

	 Statement st = connection.prepareStatement(SEARCH_SQL);

	System.out.println(SEARCH_SQL);


	ResultSet rs = st.executeQuery(SEARCH_SQL);

	System.out.println(SEARCH_SQL);

	while(rs.next()){


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

		vegetables.add( new Vegetable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),base64Image));


	}

}catch(Exception e) {
	e.printStackTrace();
}
		return vegetables;
	}
}