package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Entities.Programme;

public class DaoProgramme {
	
	private String jdbcURL="jdbc:mysql://localhost:3306/cinema";
	private String jdbcUsername="root";
	private String jdbcDriver="com.mysql.jdbc.Driver";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername,"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertProgramme(Programme p) {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("insert into programme (id_film,id_salle,date_programme) values(?,?,?)")) {
			ps.setInt(1, p.getId_film());
			ps.setInt(2, p.getId_salle());
			ps.setString(3,p.getDate_programme());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Programme getProgramme(int id) {
	    Programme p = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement("select * from programme where id_programme=?");) {
			ps.setInt(1, id);
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_film = rs.getInt("id_film");
				int id_salle= rs.getInt("id_salle");
				String date_programme=rs.getString("date_programme");
				p = new Programme(id,id_film,id_salle,date_programme);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return p;
	}
	
	public ArrayList<Programme> getAllProgrammes() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Programme> programmes = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement("select * from programme");) {
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_programme = rs.getInt("id_programme");
				int id_film = rs.getInt("id_film");
				int id_salle = rs.getInt("id_salle");
				String date_programme = rs.getString("date_programme");
				programmes.add(new Programme(id_programme,id_film,id_salle,date_programme));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return programmes;
	}
	
	public boolean deleteProgramme(int id) {	
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("delete from programme where id_programme=?");) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public boolean updateProgramme(Programme p){
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("update programme set id_film =?,id_salle=?,date_programme=? where id_programme=?");) {
			//System.out.println("updated Salle:"+ps);
			ps.setInt(1, p.getId_film());
			ps.setInt(2, p.getId_salle());
			ps.setString(3, p.getDate_programme());
			ps.setInt(4, p.getId_programme());
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
