package fr.treeptik.jdbcsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RunTime {

	public static void main(String[] args) {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee_manager","root",
					"ic06");
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement(
					"UPDATE Employee SET "
					+ "name=?, salary=?, startDate=?, "
					+ "addressId=?, departementId=? WHERE id=?");
//			statement.executeQuery("SELECT * FROM Employee");
//			ResultSet rs = statement.getResultSet();
//			
//			List<Employee> employees= new ArrayList<>();
//			
//			
//			while(rs.next()){
//				Employee employee = new Employee();
//				employee.setId(rs.getInt("id"));
//				employee.setName(rs.getString("name"));
//				employee.setSalary(rs.getInt("salary"));
//				if (rs.getDate("startDate") != null){
//					employee.setStartDate(new Date(rs.getDate("startDate").getTime()));
//				}
//				employees.add(employee);
//			}
//			System.out.println(employees);
			
//			statement.executeUpdate("INSERT INTO Employee (name, salary, startDate, addressId, departementId)"
//					+ "VALUES ('sangoku', 15000, '2015-01-01', 1, 1)");
			
			statement.setString(1, "Kevin");
			statement.setInt(2, 14000);
			statement.setDate(3, new java.sql.Date(new Date().getTime()));
			statement.setInt(4, 1);
			statement.setInt(5, 1);
			statement.setInt(6, 8);
			statement.execute();
			connection.commit();
			
			
//			PreparedStatement statement = connection.prepareStatement(
//					"DELETE FROM Employee  "
//					+ "WHERE id=?");
//			statement.setInt(1, 9);// no de ?, value
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
