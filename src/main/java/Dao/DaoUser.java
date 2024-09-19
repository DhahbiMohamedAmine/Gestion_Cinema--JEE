package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Entities.User;


public class DaoUser {

	
	
	public Connection getConnection() {
		Connection connection = null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to load JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to establish database connection: " + e.getMessage());
        }
		return connection;
	}
	
	
	
	
	
	public void insertUser(User u){
		// try-with-resource statement will auto close the connection.
		try (
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into user (name,role,email,password) values(?,?,?,?)")){
			ps.setString(1, u.getName());
			ps.setString(2, u.getRole());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public User getUser(int id) {
	    User u = null;
		// Step 1: Establishing a Connection
		try {Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement("select * from user where id_user=?");
			ps.setInt(1, id);
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String role=rs.getString("role");
				String email=rs.getString("email");
				String password=rs.getString("password");
				u = new User(id,name,role,email,password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return u;
	}
	
	
	
	
	public User getUserByEmailAndPassword(String email,String password) {
	    User u = null;
		// Step 1: Establishing a Connection
		try {Connection connection = getConnection();
				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id=rs.getInt("Id_user");
				String name = rs.getString("name");
				String role=rs.getString("role");
				u = new User(id,name,role,email,password);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return u;
	}
	
	public ArrayList<User> getAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement("select * from user");) {
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_user");
				String name = rs.getString("name");
				String role=rs.getString("role");
				String email=rs.getString("email");
				String password=rs.getString("password");
				users.add(new User(id,name,role,email,password));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	public boolean deleteUser(int id){	
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("delete from user where id_user=?");) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}return false;
	}
	
	public boolean updateUser(User u) {
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("update user set name =?,role=?,email=?,password=? where id_user=?");) {
			System.out.println("updated Salle:"+ps);
			ps.setString(1, u.getName());
			ps.setString(2, u.getRole());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setInt(5,u.getId_user());
			return ps.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
