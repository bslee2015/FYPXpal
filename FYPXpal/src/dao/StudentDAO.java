package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {

	//Get All Student
	public static String getAllStudent(){
		String students = "";
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from drivers where region = ?"); 
			stmt.setString(1, "name");
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				students = rs.getString(1);         
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se){
			se.printStackTrace();
		}
		return students;
	}

	public static void insertStudent(String id, String username, String password, String name, String classOfStudent, String email,
			String enrollmentyear, String accountCreationDateTime) {       
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into student values(?,?,?,?,?)");

			stmt.setString(1, id);
			stmt.setString(2, username);
			stmt.setString(3, password);
			stmt.setString(4, name);
			stmt.setString(5, classOfStudent);
			stmt.setString(6, email);
			stmt.setString(7,  enrollmentyear);
			stmt.setString(8, accountCreationDateTime);
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
