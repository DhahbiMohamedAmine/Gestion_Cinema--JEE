package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Entities.Salle;


public class DaoSalle {
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
	
	public void insertSalle(Salle salle) {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("insert into salle (nom_salle,nb_place) values(?,?)")) {
			ps.setString(1, salle.getNomSalle());
			ps.setInt(2, salle.getNb_place());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Salle getSalle(int id) {
	    Salle salle = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement("select * from salle where id_salle=?");) {
			ps.setInt(1, id);
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom_salle = rs.getString("nom_salle");
				int nb_place= rs.getInt("nb_place");
				salle = new Salle(id,nom_salle, nb_place);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return salle;
	}
	
	public ArrayList<Salle> getAllSalles() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		ArrayList<Salle> salles = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement("select * from salle");) {
			System.out.println(ps);
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_salle");
				String nom_salle= rs.getString("nom_salle");
				int nb_place = rs.getInt("nb_place");
				salles.add(new Salle(id,nom_salle,nb_place));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return salles;
	}
	
	public boolean deleteSalle(int id) {	
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("delete from salle where id_salle=?");) {
			ps.setInt(1, id);
			return ps.executeUpdate() > 0;
		}catch (SQLException e) {
			printSQLException(e);
		}
		return false;
	}
	
	public boolean updateSalle(Salle salle){
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement("update salle set nom_salle =?,nb_place=? where id_salle=?");) {
			System.out.println("updated Salle:"+ps);
			ps.setString(1, salle.getNomSalle());
			ps.setInt(2,salle.getNb_place());
			ps.setInt(3,salle.getId());
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

