package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Entities.Film;

public class DaoFilm {
	
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
		
		public void insertFilm(Film f) {
			// try-with-resource statement will auto close the connection.
			try (Connection connection = getConnection();
					PreparedStatement ps = connection.prepareStatement("insert into film (titre,nom_auteur) values(?,?)")) {
				ps.setString(1, f.getTitre());
				ps.setString(2, f.getNom_auteur());
				System.out.println(ps);
				ps.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		public Film getFilm(int id) {
		    Film f = null;
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement ps = connection.prepareStatement("select * from film where id_film=?");) {
				ps.setInt(1, id);
				System.out.println(ps);
				// Step 3: Execute the query or update query
				ResultSet rs = ps.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					String titre = rs.getString("titre");
					String nom_auteur= rs.getString("nom_auteur");
					f = new Film(id,titre,nom_auteur);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return f;
		}
		
		public ArrayList<Film> getAllFilms() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			ArrayList<Film> films = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement ps = connection.prepareStatement("select * from film");) {
				System.out.println(ps);
				// Step 3: Execute the query or update query
				ResultSet rs = ps.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id_film");
					String titre= rs.getString("titre");
					String nom_auteur = rs.getString("nom_auteur");
					films.add(new Film(id,titre,nom_auteur));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return films;
		}
		
		public boolean deleteFilm(int id) {	
			try (Connection connection = getConnection();
					PreparedStatement ps = connection.prepareStatement("delete from film where id_film=?");) {
				ps.setInt(1, id);
				return ps.executeUpdate() > 0;
			}catch (SQLException e) {
				printSQLException(e);
			}
			return false;
		}
		
		public boolean updateFilm(Film f){
			try (Connection connection = getConnection();
					PreparedStatement ps = connection.prepareStatement("update film set titre =?,nom_auteur=? where id_film=?");) {
				System.out.println("updated Salle:"+ps);
				ps.setString(1, f.getTitre());
				ps.setString(2,f.getNom_auteur());
				ps.setInt(3,f.getId_film());
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



