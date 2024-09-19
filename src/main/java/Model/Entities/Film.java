package Model.Entities;

public class Film {
	private int id_film;
	private String titre;
	private String nom_auteur;
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom_auteur() {
		return nom_auteur;
	}
	public Film(int id_film, String titre, String nom_auteur) {
		this.id_film = id_film;
		this.titre = titre;
		this.nom_auteur = nom_auteur;
	}
	@Override
	public String toString() {
		return "Film [id_film=" + id_film + ", titre=" + titre + ", nom_auteur=" + nom_auteur + ", id_salle=" + "]";
	}
	public void setNom_auteur(String nom_auteur) {
		this.nom_auteur = nom_auteur;
	}

}
