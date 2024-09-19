package Model.Entities;



public class Programme {
	private int id_programme;
	private int id_film;
	private int id_salle;
	private String date_programme;
	public int getId_programme() {
		return id_programme;
	}
	public void setId_programme(int id_programme) {
		this.id_programme = id_programme;
	}
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public int getId_salle() {
		return id_salle;
	}
	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}
	public String getDate_programme() {
		return date_programme;
	}
	public void setDate_programme(String date_programme) {
		this.date_programme = date_programme;
	}
	public Programme(int id_programme, int id_film, int id_salle, String date_programme) {
		super();
		this.id_programme = id_programme;
		this.id_film = id_film;
		this.id_salle = id_salle;
		this.date_programme = date_programme;
	}
	
	
	

}
